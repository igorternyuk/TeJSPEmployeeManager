package model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.EmployeeDTO;
/**
 *
 * @author igor
 * Last edited 27-10-2017
 * 
 */
public class EmployeeDAO implements ObligationDAO<EmployeeDTO> {
    private final static DatabaseManager manager = DatabaseManager.getInstance();
    private static final String SQL_INSERT = "INSERT INTO employees VALUES(null,"
                                             + "?,?,?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE employees SET name = ?,"
            + "surname = ?, age = ?, address = ?, phone = ?, email = ?, salary = ?"
            + "WHERE id = ?;";
    private static final String SQL_DELETE = "DELETE FROM employees WHERE id=?;";
    private static final String SQL_READ_ALL = "SELECT * FROM employees";
    private static final String SQL_READ_BY_ID = "SELECT * FROM employees WHERE"
            + " id = ?;";

    @Override
    public boolean insert(EmployeeDTO obj) {
        if(obj == null) return false;
        PreparedStatement ps;
        try {
            ps = manager.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setInt(3, obj.getAge());
            ps.setString(4, obj.getAddress());
            ps.setString(5, obj.getPhone());
            ps.setString(6, obj.getEmail());
            ps.setDouble(7, obj.getSalary());
            System.out.println("SQL = " + ps.toString());
            if(ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, 
                            null, ex);
        } finally {
            manager.closeConnection();
        }   
        return false;
    }

    @Override
    public boolean update(EmployeeDTO obj) {
        if(obj == null) return false;
        PreparedStatement ps;
        try {
            ps = manager.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setInt(3, obj.getAge());
            ps.setString(4, obj.getAddress());
            ps.setString(5, obj.getPhone());
            ps.setString(6, obj.getEmail()); 
            ps.setDouble(7, obj.getSalary());
            ps.setInt(8, obj.getId());
            System.out.println("SQL = " + ps.toString());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        } finally {
            manager.closeConnection();
        }     
        return false;
    }

    @Override
    public boolean remove(Object id) {
        if(id == null) return false;
        PreparedStatement ps;
        try {
            ps = manager.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int)id);
            System.out.println("SQL = " + ps.toString());
            if(ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }   finally { 
            manager.closeConnection();
        }
        return false;
    }
    
    @Override
    public EmployeeDTO readById(Object id) {
        if(id == null) return null;
        PreparedStatement ps;
        ResultSet rs;
        EmployeeDTO employee = null;
        try {            
            ps = manager.getConnection().prepareStatement(SQL_READ_BY_ID);
            ps.setInt(1, (int)id);
            rs = ps.executeQuery();
            if(rs.next()){
                employee = getEmployeeFromResultSet(rs);
            }            
            return employee;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE,
                             null, ex);
        } finally {
            manager.closeConnection();
        }
        return employee;
    }

    @Override
    public List<EmployeeDTO> readAll() {
        List<EmployeeDTO> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = manager.getConnection().prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(getEmployeeFromResultSet(rs));
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null,
                                                              ex);
        } finally {
            manager.closeConnection();
        }
        return list;
    }

    @Override
    public List<EmployeeDTO> search(String filter, String regExp) {
        List<EmployeeDTO> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = manager.getConnection();
            String cmd;
            if(regExp.equals("")){
                cmd = SQL_READ_ALL;
            } else {
                cmd = "SELECT * FROM employees WHERE " + filter + " LIKE '%"+ 
                       regExp + "%';";
            }
            System.out.println("SQL = " + cmd);
            ps = con.prepareStatement(cmd);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(getEmployeeFromResultSet(rs));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null,
                                                              ex);
        } finally {
            manager.closeConnection();
        }
        return list;
    }
    
    public List<EmployeeDTO> search(String filter, String regExp, int ageMin,
                                    int ageMax) {
        List<EmployeeDTO> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = manager.getConnection();
            String cmd;
            if(regExp.equals("")){
                cmd = "SELECT * FROM employees WHERE age >= " + ageMin +
                      " AND age <= " + ageMax + " ORDER BY age;";
            }
            else{
                cmd = "SELECT * FROM employees WHERE " + filter + " LIKE '%"+ 
                    regExp + "%' AND age >= " + ageMin + " AND age <= " + ageMax +
                    " ORDER BY age;";
            }
            System.out.println("SQL" + cmd);
            ps = con.prepareStatement(cmd);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(getEmployeeFromResultSet(rs));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null,
                                                              ex);
        } finally {
            manager.closeConnection();
        }
        return list;
    }
    
    private EmployeeDTO getEmployeeFromResultSet(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String surname = rs.getString(3);
        int age = rs.getInt(4);
        String address = rs.getString(5);
        String phone = rs.getString(6);
        String email = rs.getString(7);
        double salary = rs.getDouble(8);
        EmployeeDTO e = new EmployeeDTO(id, name, surname, age, address, phone,
                                        email, salary);
        return e;
    }
    
    /*public static void main(String[] args) {
       EmployeeDAO dao = new EmployeeDAO();
       //dao.remove(30);
       //List<EmployeeDTO> list = dao.search("an", "name", 30, 50);
       
       List<EmployeeDTO> list = dao.search("name", "ol");
       list.forEach(e -> {
           System.out.println(e);
       });
        System.out.println("-------------------------");
        EmployeeDTO e31 = dao.readById(1);
        if(e31 != null){
            System.out.println(e31);
        }
    }*/    
}
