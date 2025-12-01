package com.bayraksamet.service;

import com.bayraksamet.model.UpdateUserRequest;
import com.bayraksamet.model.User;
import com.bayraksamet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsersList() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id = " + id));
    }

    public List<User> getUserWithParams(String email) {
        if (email == null || email.trim().isEmpty()) {
            return userRepository.findAll();
        }
        return userRepository.findByEmailIgnoreCase(email);
    }

    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    public boolean deleteUser(int id) {
        User dUser = getUserById(id);

        if (dUser == null) {
            return false;
        }

        userRepository.delete(dUser);
        return true;
    }

    public User updateUser(int id, UpdateUserRequest request) {

        User findUser = userRepository.findById(id).orElse(null);
        if (findUser == null) return null;

        if (request.getName() != null && !request.getName().trim().isEmpty()) {
            findUser.setName(request.getName());
        }
        if (request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
            findUser.setEmail(request.getEmail());
        }
        if (request.getPassword() != null && !request.getPassword().trim().isEmpty()) {
            findUser.setPassword(request.getPassword());
        }

        return userRepository.save(findUser);
    }
}
