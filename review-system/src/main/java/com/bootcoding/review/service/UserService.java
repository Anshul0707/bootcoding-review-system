package com.bootcoding.review.service;

import com.bootcoding.review.model.User;
import com.bootcoding.review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String createUser(User user){
        print(user);
        userRepository.save(user);
        return "SUCCESSFULLY USER CREATED!";
    }

    private void print(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getEmailId());
        System.out.println(user.getPhone());
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    public int deleteUserById(int userId) {
        return userRepository.deleteUserById(userId);
    }

    public int updateUserById(User user, int userId) {
        return userRepository.updateUserById(user,userId);
    }
}
