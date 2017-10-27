package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igor
 * Last edited 27-10-2017
 */

public class DatabaseManager {
    public static DatabaseManager instance = null;
    private final String driver;
    private final String server;
    private final String port;
    private final String url;
    private final String database;
    private final String user;
    private final String password;
    private Connection connection;
 
    public static synchronized DatabaseManager getInstance(){
        if(instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }

    private DatabaseManager() {
        this.driver = "com.mysql.jdbc.Driver";
        this.server = "localhost";
        this.port = "3306";
        this.database = "db_employees";
        this.url = "jdbc:mysql://" + server+ ":" + port + "/" + database;
        this.user = "igorternyuk";
        this.password = "1319";
        try {
            Class.forName(driver); 
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    public DatabaseManager(String driver, String server, String port, 
                           String database, String user, String password) {
        this.driver = driver;
        this.server = server;
        this.port = port;
        this.database = database;
        this.url = "jdbc:mysql://" + server+ ":" + port + "/" + database;
        this.user = user;
        this.password = password;
        try {
            Class.forName(driver); 
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

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

    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() { 
        instance = null;
    }                
}
