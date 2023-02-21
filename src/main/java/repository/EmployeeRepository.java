package repository;

import model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Optional<Employee> findByLastName(String lastName);
    void updateSalary(Integer id);
}
