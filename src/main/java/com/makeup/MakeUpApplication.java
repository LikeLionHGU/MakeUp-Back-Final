package com.makeup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MakeUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakeUpApplication.class, args);
    }

}
