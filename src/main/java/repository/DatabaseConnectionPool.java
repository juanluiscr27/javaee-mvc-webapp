package repository;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnectionPool {
    private static BasicDataSource dataSource = null;

    public synchronized static Connection getConnection() {
        Connection connection = null;

        try {
            if (dataSource == null) {
                PropertiesFileReader propReader = new PropertiesFileReader("src/main/resources/config.properties");

                dataSource = new BasicDataSource();
                dataSource.setDriverClassName(propReader.getProperty("mysql.db.driver"));
                dataSource.setUrl(propReader.getProperty("mysql.db.url"));
                dataSource.setUsername(propReader.getProperty("mysql.db.user"));
                dataSource.setPassword(propReader.getProperty("mysql.db.password"));

                dataSource.setInitialSize(Integer.parseInt(propReader.getProperty("mysql.db.pool.initsize"))); // The initial number of connections that
                // are created when the pool is started.
                dataSource.setMaxTotal(Integer.parseInt(propReader.getProperty("mysql.db.pool.maxsize"))); // The maximum number of active connections
                // that can be allocated from this pool
                dataSource.setMaxWaitMillis(3000L);
            }
            connection = dataSource.getConnection();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}

