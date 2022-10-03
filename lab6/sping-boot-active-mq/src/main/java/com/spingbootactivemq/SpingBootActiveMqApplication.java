package com.spingbootactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpingBootActiveMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBootActiveMqApplication.class, args);
    }

}
