package com.bayraksamet.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bayraksamet"})
@EnableJpaRepositories(basePackages = "com.bayraksamet.repository")
@EntityScan(basePackages = "com.bayraksamet.model")
public class SpringBootExceptionManagementStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExceptionManagementStarter.class, args);
    }

}
