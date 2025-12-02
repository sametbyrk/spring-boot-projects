package com.bayraksamet.service;

import com.bayraksamet.dto.DtoUser;
import com.bayraksamet.dto.DtoUserIU;
import com.bayraksamet.entities.User;
import com.bayraksamet.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<DtoUser> getAllUsersList() {
        List<DtoUser> dtoList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            DtoUser dto = new DtoUser();
            BeanUtils.copyProperties(user, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public DtoUser getUserById(Integer id) {
        DtoUser dto = new DtoUser();
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User dbUser = optional.get();
            BeanUtils.copyProperties(dbUser, dto);
        }
        return dto;
    }

    public DtoUser saveUser(DtoUserIU dtoUserIU) {
        DtoUser response = new DtoUser();

        User user = new User();
        BeanUtils.copyProperties(dtoUserIU, user);

        User dbUser = userRepository.save(user);

        BeanUtils.copyProperties(dbUser, response);

        return response;
    }

    public boolean deleteUser(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.delete(optional.get());
            return true;
        }
        return false;
    }

    public DtoUser updateUser(int id, DtoUserIU dtoUserIU) {
        DtoUser dto = new DtoUser();
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User dbUser = optional.get();
            dbUser.setName(dtoUserIU.getName());
            dbUser.setEmail(dtoUserIU.getEmail());
            User updatedUser = userRepository.save(dbUser);
            BeanUtils.copyProperties(updatedUser, dto);
            return dto;
        }
        return null;
    }

    public List<DtoUser> getUserWithParams(String name) {
        List<User> userList = userRepository.findByNameContainingIgnoreCase(name);
        List<DtoUser> dtoList = new ArrayList<>();
        for (User user : userList) {
            DtoUser dto = new DtoUser();
            BeanUtils.copyProperties(user, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
}

