package com.fit.se.ChuyenBayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ChuyenBayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChuyenBayServiceApplication.class, args);
	}

}
