package com.bootcoding.review.controller;

import com.bootcoding.review.model.User;
import com.bootcoding.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/health/check")
    public String healthCheckup() {
        return "I am alive!";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        // create user
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public int deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/user/{id}")
    public int updateUserById(@RequestBody User user, @PathVariable int id) {
        return userService.updateUserById(user, id);
    }
}
