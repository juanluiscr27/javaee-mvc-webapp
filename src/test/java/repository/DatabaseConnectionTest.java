package repository;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    Connection connection;
    @Test
    void testGetDatabaseConnection() {
        connection = DatabaseConnection.getConnection();
        assertNotNull(connection);
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
