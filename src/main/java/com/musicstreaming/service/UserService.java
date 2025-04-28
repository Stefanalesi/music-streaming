package com.musicstreaming.service;

import com.musicstreaming.entity.User;
import com.musicstreaming.repository.UserRepository;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public List<User> getAllUsers() {
        try {
            return userRepository.getAllUsers();
        } finally {
            userRepository.close();
        }
    }

    public void save(User user) {
        try {
            userRepository.save(user);
        } finally {
            userRepository.close();
        }
    }
}
