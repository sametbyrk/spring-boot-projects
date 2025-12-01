package com.bayraksamet.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.bayraksamet"})
@SpringBootApplication
public class Spring1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring1Application.class, args);
    }

}
