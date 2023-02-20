package repository;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Database Connection
 */
public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        PropertiesFileReader propReader = new PropertiesFileReader("src/main/resources/config.properties");
        String url = propReader.getProperty("mysql.db.url");
        String user = propReader.getProperty("mysql.db.user");
        String password = propReader.getProperty("mysql.db.password");

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Failed to create a connection to database.\n" + ex.getMessage());
        }
        return connection;
    }
}
