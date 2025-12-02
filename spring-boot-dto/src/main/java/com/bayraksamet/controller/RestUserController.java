package com.bayraksamet.controller;

import com.bayraksamet.dto.DtoUser;
import com.bayraksamet.dto.DtoUserIU;
import com.bayraksamet.entities.User;
import com.bayraksamet.repository.UserRepository;
import com.bayraksamet.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/user")
public class RestUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/list")
    public List<DtoUser> getAllUsersList() {
        return userService.getAllUsersList();
    }

    @GetMapping("/list/{id}")
    public DtoUser getUserById(@PathVariable(name = "id", required = true) int id) {
        return userService.getUserById(id);
    }
    @PostMapping("/save-user")
    public DtoUser saveUser(@RequestBody DtoUserIU dtoUserIU) {
        return userService.saveUser(dtoUserIU);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id) {
        boolean isDeleted = userService.deleteUser(id);

        if (isDeleted) {
            return "Kullanıcı başarıyla silindi";
        } else {
            return "Silinecek kullanıcı bulunamadı";
        }
    }

    @PutMapping("/update/{id}")
    public DtoUser updateUser(@PathVariable(name = "id") Integer id, @RequestBody DtoUserIU dtoUserIU) {
        return userService.updateUser(id, dtoUserIU);
    }

    @GetMapping("/search")
    public List<DtoUser> getUserWithParams(@RequestParam(name = "name") String name) {
        return userService.getUserWithParams(name);
    }
}
