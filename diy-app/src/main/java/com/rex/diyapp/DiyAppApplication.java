package com.rex.diyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tyche.framework","com.rex.diyapp"})
public class DiyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiyAppApplication.class, args);
    }

}
