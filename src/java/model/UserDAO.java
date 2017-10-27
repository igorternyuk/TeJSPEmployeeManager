package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.UserDTO;

/**
 *
 * @author igor
 * Last edited 27-10-2017
 *     id integer not null primary key auto_increment,
    name VARCHAR(40),
    email VARCHAR(40),
    password VARCHAR(50)
 */
public class UserDAO implements ObligationDAO<UserDTO>{    
    private final DatabaseManager manager = DatabaseManager.getInstance();
    private static final String SQL_INSERT = "INSERT INTO users values(null,?,?,"
            + "?);";
    private static final String SQL_UPDATE = "UPDATE users set name = ?, "
            + "email = ?, password = ? WHERE id = ?;";
    private static final String SQL_DELETE = "DELETE FROM users WHERE id = ?;";
    private static final String SQL_READ_ALL = "SELECT * FROM users;";
    private static final String SQL_READ_BY_ID = "SELECT * FROM users WHERE id = ?;";
    
    @Override
    public boolean insert(UserDTO obj) {
        if(obj == null) return false;
        PreparedStatement ps;
        try {
            ps = manager.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getPassword());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            manager.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(UserDTO obj) {
        if(obj == null) return false;
        PreparedStatement ps;
        try {
            ps = manager.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getPassword());
            ps.setInt(4, obj.getId());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            manager.closeConnection();
        }
        return false;
    }

    @Override
    public boolean remove(Object key) {
        if(key == null) return false;
        PreparedStatement ps;
        try {
            ps = manager.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int)key);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            manager.closeConnection();
        }
        return false;
    }

    @Override
    public UserDTO readById(Object key) {
        if(key == null) return null;
        PreparedStatement ps;
        ResultSet rs;
        UserDTO user = null;
        try {
            ps = manager.getConnection().prepareStatement(SQL_READ_BY_ID);
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
                user = retrieveUserDTOFromResultSet(rs);
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            manager.closeConnection();
        }
        return user;
    }

    @Override
    public List<UserDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        List<UserDTO> users = new ArrayList<>();
        try {
            ps = manager.getConnection().prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next()){
                users.add(retrieveUserDTOFromResultSet(rs));
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            manager.closeConnection();
        }
        return users;
    }

    @Override
    public List<UserDTO> search(String filter, String regExp) {
        PreparedStatement ps;
        ResultSet rs;
        List<UserDTO> users = new ArrayList<>();
        try {
            String cmd = "SELECT * FROM users WHERE " + filter + " LIKE '%" + regExp
                    + "%';";
            ps = manager.getConnection().prepareStatement(cmd);
            rs = ps.executeQuery();
            while(rs.next()){
                users.add(retrieveUserDTOFromResultSet(rs));
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            manager.closeConnection();
        }
        return users;
    }

    public UserDTO exists(UserDTO user){
        String email = user.getEmail();
        String pass = user.getPassword();
        UserDTO newUser = new UserDTO(email,pass);
        
        List<UserDTO> searchByEmail = this.search("email", email);
        List<UserDTO> searchByPassword = this.search("password", pass);
        
        if(searchByEmail.isEmpty()){
            if(searchByPassword.isEmpty()){
                newUser.addError(Error.LOGIN_AND_PASSWORD_INCORRECT);
            }else {
                newUser.addError(Error.LOGIN_INCORRECT);
            }
        } else {
            if(searchByPassword.isEmpty()){
               newUser.addError(Error.PASSWORD_INCORRECT); 
            }
            else if(searchByEmail.get(0).getId() != searchByPassword.get(0).getId()){
                newUser.addError(Error.LOGIN_AND_PASSWORD_FROM_DIFFERENT_ACCOUNTS);
            } else {
                newUser = searchByEmail.get(0);
            }
        }
        return newUser;
    }   

    private UserDTO retrieveUserDTOFromResultSet(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String email = rs.getString(3);
        String password = rs.getString(4);
        UserDTO user = new UserDTO(id, name, email, password);
        return user;
    }
    
   /* public static void main(String[] args) {
        UserDAO dao = new  UserDAO();
        UserDTO test_user = new UserDTO("xmonad@ukr.net", "1319");
        //dao.update(user);
        List<UserDTO> users = dao.readAll();
        users.forEach(e -> {
            System.out.println(e);
        });
        
        System.err.println("--------------------------------");
        UserDTO new_user = dao.exists(test_user);
        System.out.println(new_user);
    }
*/
}
