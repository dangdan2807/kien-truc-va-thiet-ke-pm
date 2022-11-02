package springboot_redis.example;

import com.google.gson.Gson;
import springboot_redis.model.Employee;
import springboot_redis.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RedisExample {
    private static Gson gson = new Gson();
    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        Map<String, Boolean> res = new HashMap<>();
        res.put("success", true);
        return "";
    }

    @GetMapping("")
    public String getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        Map<String, List<Employee>> res = new HashMap<>();
        res.put("employee", employees);
        return gson.toJson(res);
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable(value = "id") Integer id) {
        Employee employee = employeeService.getOneEmployee(id);
        Map<String, Employee> res = new HashMap<>();
        res.put("employee", employee);
        return gson.toJson(res);
    }

    @PatchMapping("/{id}")
    public String updateEmployee(@PathVariable(value = "id") Integer id, @RequestBody Employee employee) {
        employee.setEmpId(id);
        employeeService.saveEmployee(employee);
        Map<String, Employee> res = new HashMap<>();
        res.put("employee", employee);
        return gson.toJson(res);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {
        employeeService.deleteEmployee(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("success", true);
        return gson.toJson(res);
    }
}
