package repository;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.ConnectionImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for Database Connection class with MySQL")
class DatabaseConnectionTest {
    Connection connection;
    @Test
    void testGetDatabaseConnection() {
        connection = DatabaseConnection.getConnection();
        assertEquals(ConnectionImpl.class, connection.getClass());
    }

    @AfterEach
    void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing the database connection " + e.getMessage());
        }
    }
}
