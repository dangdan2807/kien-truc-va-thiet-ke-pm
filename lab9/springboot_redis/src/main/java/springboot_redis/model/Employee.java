package springboot_redis.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Employee")

public class Employee implements Serializable {
    @Id
    private Integer empId;
    private String empName;
    private Double empSalary;
}
