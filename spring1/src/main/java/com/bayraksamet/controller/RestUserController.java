package com.bayraksamet.controller;

import com.bayraksamet.model.UpdateUserRequest;
import com.bayraksamet.model.User;
import com.bayraksamet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/user")
public class RestUserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/list")
    public List<User> getAllUsersList() {
        return userService.getAllUsersList();
    }

    @GetMapping("/list/{id}")
    public User getUserById(@PathVariable(name = "id", required = true) int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/with-params")
    public List<User> getUserWithParams(@RequestParam(required = false) String email) {
        return userService.getUserWithParams(email);
    }
    @PostMapping("/save-user")
    public User saveUser(@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @DeleteMapping(path = "/delete-user/{id}")
    public boolean deleteUser(@PathVariable(name = "id") int id) {
        return userService.deleteUser(id);
    }
    @PutMapping("/update-user/{id}")
    public User updateUser(@PathVariable int id,
                           @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }
}
