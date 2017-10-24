package model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uml.Employee;
/**
 *
 * @author igor
 * 
 */
public class DAOEmployee implements DAO {
    private final DatabaseManager manager = new DatabaseManager();
    private static final String SQL_INSERT = "INSERT INTO employees VALUES(null,"
                                             + "?,?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE employees SET name = ?,"
            + "surname = ?, age = ?, address = ?, phone = ?, email = ? WHERE "
            + "id = ?;";
    private static final String SQL_DELETE = "DELETE FROM employees WHERE id=?;";
    private static final String SQL_READ_ALL = "SELECT * FROM employees";
    //private static final String SQL_SEARCH = "SELECT * FROM employees WHERE ? LIKE '%"+"?"+"%'";

    @Override
    public boolean insert(Object obj) {
        Employee employee = (Employee)obj;
        PreparedStatement ps;
        try {
            Connection con = manager.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            //ps.setInt(1, employee.getId());
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getAddress());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());            
            ps.executeUpdate();
            System.out.println("SQL = " + ps.toString());
            ps.close();
            manager.disconnect();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, 
                            null, ex);
        }     
        return false;
    }

    @Override
    public boolean update(Object obj) {
        Employee employee = (Employee)obj;
        PreparedStatement ps;
        try {
            Connection con = manager.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            //ps.setInt(1, employee.getId());
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getAddress());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail()); 
            ps.setInt(7, employee.getId());  
            ps.executeUpdate();
            System.out.println("SQL = " + ps.toString());
            ps.close();
            manager.disconnect();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }     
        return false;
    }

    @Override
    public boolean remove(int id) {
        PreparedStatement ps;
        try {
            Connection con = manager.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("SQL = " + ps.toString());
            ps.close();
            manager.disconnect();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }     
        return false;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = manager.getConnection();
            ps = con.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(getEmployeeFromResultSet(rs));
            }
            ps.close();
            manager.disconnect();
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, null,
                                                              ex);
        }
        return list;
    }

    @Override
    public List<Employee> search(String regExp, String filter) {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = manager.getConnection();
            String cmd = "SELECT * FROM employees WHERE " + filter + " LIKE '%"+ 
                    regExp + "%';";
            ps = con.prepareStatement(cmd);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(getEmployeeFromResultSet(rs));
            }
            ps.close();
            manager.disconnect();
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, null,
                                                              ex);
        }
        return list;
    }
    
    public List<Employee> search(String regExp, String filter, int ageMin, int ageMax) {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = manager.getConnection();
            String cmd;
            if("".equals(filter)){
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
            ps.close();
            manager.disconnect();
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, null,
                                                              ex);
        }
        return list;
    }
    
    private Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String surname = rs.getString(3);
        int age = rs.getInt(4);
        String address = rs.getString(5);
        String phone = rs.getString(6);
        String email = rs.getString(7);
        Employee e = new Employee(id, name, surname, age, address, phone,
                                  email);
        return e;
    }
    
    public static void main(String[] args) {
       DAOEmployee dao = new DAOEmployee();
       List<Employee> list = dao.search("an", "name", 30, 50);
       list.forEach(e -> {
           System.out.println(e);
       });
    }    
}
