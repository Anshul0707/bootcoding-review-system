package com.bootcoding.review.controller;

import com.bootcoding.review.model.User;
import com.bootcoding.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/health/check")
    public String healthCheckup(){
        return "I am alive!";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        // create user
        return userService.createUser(user);
    }

}
