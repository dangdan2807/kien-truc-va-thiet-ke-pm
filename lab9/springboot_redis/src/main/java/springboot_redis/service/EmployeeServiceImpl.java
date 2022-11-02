package springboot_redis.service;

import springboot_redis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeServiceImpl {
    private final String HASH_KEY_NAME = "Employee";

    @Autowired
    private RedisTemplate redisTemplate;

    public void saveEmployee(Employee emp) {
        redisTemplate.opsForHash().put(HASH_KEY_NAME, emp.getEmpId(), emp);
    }

    public Employee getOneEmployee(Integer id) {
        return (Employee) redisTemplate.opsForHash().get(HASH_KEY_NAME,id);
    }

    public List<Employee> getAllEmployees() {
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }

    public void deleteEmployee(Integer id) {
        redisTemplate.opsForHash().delete(HASH_KEY_NAME, id);
    }
}
