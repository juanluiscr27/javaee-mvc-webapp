package repository;

import model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
    @DisplayName("Tests for Employee Data Access class")
    class EmployeeDAOTest {
    @DisplayName("Find an Employee When Provided an ID")
    @Test
    void testFindEmployeeById(){
        int expectedId = 1;
        Optional<Employee> employee;
        EmployeeRepository employeeDAO = new EmployeeDAO();
        try {
            employee = employeeDAO.find(expectedId);
            assertEquals(expectedId, employee.orElse(new Employee()).getEmp_no());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}