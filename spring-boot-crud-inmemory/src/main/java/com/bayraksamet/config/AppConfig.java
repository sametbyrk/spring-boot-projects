package com.bayraksamet.config;

import com.bayraksamet.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class AppConfig {

    @Bean
    public List<User> userList() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(1,"Samet","sb","s1231"));
        usersList.add(new User(2,"Efe","eb","e1231"));
        return usersList;
    }
}

