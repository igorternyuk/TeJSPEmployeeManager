package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igor
 */
public class DatabaseManager {
    private String driver;
    private String server;
    private String port;
    private String url;
    private String database;
    private String user;
    private String password;
    private Connection con = null;
    
    public DatabaseManager() {
        this.driver = "com.mysql.jdbc.Driver";
        this.server = "localhost";
        this.port = "3306";
        this.database = "db_employees";
        this.url = "jdbc:mysql://" + server+ ":" + port + "/" + database;
        this.user = "igorternyuk";
        this.password = "1319";      
    }
    

    /*public DatabaseManager(String database, String user, String password) {
        //
        this.driver = "com.mysql.jdbc.Driver";
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public DatabaseManager(String user, String password) {
        //
        this.driver = "com.mysql.jdbc.Driver";
        this.url = url;
        this.user = user;
        this.password = password;
    }*/

    public String getDriver() {
        return driver;
    }

    public String getServer() {
        return server;
    }

    public String getPort() {
        return port;
    }

    public String getUrl() {
        return url;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);      
        }
        return con;
    }
    
    public void disconnect() throws SQLException{ 
        con.close();
         con = null;
    }
                
}
