package startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

public class ContextManager implements ServletContextListener {
	@Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("=== Application Context Created ===");
//		Iterator<Driver> driversIterator = ServiceLoader.load(Driver.class).iterator();
//		while (driversIterator.hasNext()) {
//			try {
//				// Instantiates the driver
//				driversIterator.next();
//			} catch (Throwable t) {
//                contextEvent.getServletContext().log("JDBC Driver registration failure.", t);
//			}
//		}
    }
	@Override
    public final void contextDestroyed(ServletContextEvent event) {
        // First close any background tasks which may be using the DB
        // ... Then close any DB connection pools ...

        // Now deregister JDBC drivers in this context's ClassLoader:
        // Get the webapp's ClassLoader
		// final ClassLoader cl = event.getServletContext().getClassLoader();
//        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        // Loop through all drivers
//        final Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while (drivers.hasMoreElements()) {
//            Driver driver = drivers.nextElement();
//            if (driver.getClass().getClassLoader() == loader) {
//                // This driver was registered by the webapp's ClassLoader, so deregister it:
//                try {
//                    // log.info("Deregistering JDBC driver {}", driver);
//                    System.out.println("Deregistering JDBC driver " + driver);
//                    DriverManager.deregisterDriver(driver);
//                } catch (SQLException ex) {
//                    // log.error("Error deregistering JDBC driver {}", driver, ex);
//                    System.out.println("Error deregistering JDBC driver " + driver + "\n" + ex.getMessage());
//                }
//            } else {
//                // driver was not registered by the webapp's ClassLoader and may be in use elsewhere
//                // log.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader", driver);
//                System.out.println("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader" + driver);
//            }
//        }
        System.out.println("=== Application Context Destroyed ===");
    }
}
