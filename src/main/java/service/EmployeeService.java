package service;

import model.Employee;
import repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        // Generate here Employee UUID
        Employee savedEmployee = null;
        try {
            return employeeRepo.add(employee);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Employee> findAllEmployees() {
        try {
            return employeeRepo.findAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<Employee>();
        }
    }
}
