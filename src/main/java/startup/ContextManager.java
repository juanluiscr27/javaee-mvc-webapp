package startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Enumeration;

public class ContextManager implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("=== Application Context Created ===");
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
    }
    public final void contextDestroyed(ServletContextEvent event) {
        // First close any background tasks which may be using the DB
        // ... Then close any DB connection pools ...

        // Now deregister JDBC drivers in this context's ClassLoader:
        // Get the webapp's ClassLoader
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // Loop through all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == loader) {
                // This driver was registered by the webapp's ClassLoader, so deregister it:
                try {
                    // log.info("Deregistering JDBC driver {}", driver);
                    System.out.println("Deregistering JDBC driver " + driver);
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException ex) {
                    // log.error("Error deregistering JDBC driver {}", driver, ex);
                    System.out.println("Error deregistering JDBC driver " + driver + "\n" + ex.getMessage());
                }
            } else {
                // driver was not registered by the webapp's ClassLoader and may be in use elsewhere
                // log.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader", driver);
                System.out.println("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader" + driver);
            }
        }
        System.out.println("=== Application Context Destroyed ===");
    }
}
