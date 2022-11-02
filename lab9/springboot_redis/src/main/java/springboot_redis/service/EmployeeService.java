package springboot_redis.service;

import springboot_redis.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee emp);

    Employee getOneEmployee(Integer id);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer id);
}
