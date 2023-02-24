package repository;

import model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO implements EmployeeRepository {
    @Override
    public Employee add(Employee employee) throws SQLException {
        return employee;
    }

    @Override
    public Optional<Employee> find(Integer id) {
        Employee employee = null;
        try {
            Connection connection = DatabaseConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees" +
                    " WHERE emp_no = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5).charAt(0),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getString(3)
                );
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(employee);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5).charAt(0),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getString(3)
                ));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Employee update(Employee employee) {
        return employee;
    }

    @Override
    public void delete(Employee employee) {
        return;
    }

    @Override
    public Optional<Employee> findByLastName(String lastName) {
        return Optional.of(new Employee());
    }

    @Override
    public void updateSalary(Integer id) {

    }
}
