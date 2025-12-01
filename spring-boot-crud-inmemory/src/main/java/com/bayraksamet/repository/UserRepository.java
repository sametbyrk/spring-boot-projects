package com.bayraksamet.repository;

import com.bayraksamet.model.UpdateUserRequest;
import com.bayraksamet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private List<User> userList;

    public List<User> getAllUsersList() {
        return userList;
    }
    public User getUserById(int id) {
        User findUser = null;
        for (User user : userList) {
            if (user.getId() == id) {
                findUser = user;
                break;
            }
        }
        return findUser;
    }

    public List<User> getUserWithParams(String email) {

        if (email == null || email.trim().isEmpty()) {
            return userList;
        }

        List<User> userWithParams = new ArrayList<>();

        for (User user : userList) {
            if (user.getEmail().equalsIgnoreCase(email.trim())) {
                userWithParams.add(user);
            }
        }

        return userWithParams;
    }
    public User saveUser(User newUser) {
        int newId = userList.stream()
                .mapToInt(User::getId)
                .max()
                .orElse(0) + 1;

        newUser.setId(newId);

        userList.add(newUser);

        return newUser;
    }
    public boolean deleteUser(int id) {

        User deleteUser = null;

        for (User user : userList) {
            if (user.getId() == id) {
                deleteUser = user;
                break;
            }
        }
        if (deleteUser == null) {
            return false;
        }

        userList.remove(deleteUser);

        return true;
    }
    private User findUserById(int id) {
        User findUser = null;
        for (User user : userList) {
            if (user.getId() == id) {
                findUser = user;
                break;
            }

        }
        return findUser;
    }

    public User updateUser(int id, UpdateUserRequest request) {

        for (User user : userList) {
            if (user.getId() == id) {

                // Name gönderildiyse güncelle
                if (request.getName() != null && !request.getName().trim().isEmpty()) {
                    user.setName(request.getName());
                }
                // Email gönderildiyse güncelle
                if (request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
                    user.setEmail(request.getEmail());
                }
                // Password gönderildiyse güncelle
                if (request.getPassword() != null && !request.getPassword().trim().isEmpty()) {
                    user.setPassword(request.getPassword());
                }

                return user;
            }
        }

        return null;
    }
}
