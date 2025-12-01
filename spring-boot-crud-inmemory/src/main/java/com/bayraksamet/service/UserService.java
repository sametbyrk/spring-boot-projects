package com.bayraksamet.service;

import com.bayraksamet.model.UpdateUserRequest;
import com.bayraksamet.model.User;
import com.bayraksamet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsersList() {
        return userRepository.getAllUsersList();
    }
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
    public List<User> getUserWithParams(String email) {
        return userRepository.getUserWithParams(email);
    }
    public User saveUser(User newUser) {
        return userRepository.saveUser(newUser);
    }
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }
    public User updateUser(int id, UpdateUserRequest request) {
        return userRepository.updateUser(id, request);
    }
}
