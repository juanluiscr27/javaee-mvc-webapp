package repository;

import model.Employee;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeDAOTest {
    @Test
    void testFind() throws SQLException {
        int expectedId = 1;
        EmployeeRepository employeeDAO = new EmployeeDAO();
        Optional<Employee> employee = employeeDAO.find(expectedId);
        assertEquals(expectedId, employee.orElse(new Employee()).getEmp_no());
    }
}