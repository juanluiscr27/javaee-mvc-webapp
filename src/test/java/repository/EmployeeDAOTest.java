package repository;

import model.Employee;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeDAOTest {
    @Test
    void testFindEmployeeById(){
        int expectedId = 1;
        Optional<Employee> employee;
        EmployeeRepository employeeDAO = new EmployeeDAO();
        try {
            employee= employeeDAO.find(expectedId);
            assertEquals(expectedId, employee.orElse(new Employee()).getEmp_no());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}