package repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test for Configuration Properties File Reader class")
class PropertiesFileReaderTest {
    @Test
    void testReadConfigPropertiesFile() {
        //Create an input stream to read the properties file
        String actualUrl;
        String actualUser;
        String actualPassword;

        PropertiesFileReader propReader = new PropertiesFileReader("mysql.db","config.properties");

        actualUrl = propReader.getProperty("url");
        actualUser = propReader.getProperty("user");
        actualPassword = propReader.getProperty("password");

        assertAll(
                () -> assertEquals("jdbc:mysql://localhost:3307/test", actualUrl),
                () ->assertEquals("test_user", actualUser),
                () -> assertEquals("secret", actualPassword)
        );
    }
}