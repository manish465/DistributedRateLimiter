package com.manish.user.service;

import com.manish.user.dto.AddUserRequest;
import com.manish.user.entity.User;
import com.manish.user.exception.ApplicationException;
import com.manish.user.mapper.UserMapper;
import com.manish.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String addUser(AddUserRequest addUserRequest) {
        User user;

        try {
            user = userRepository.save(userMapper.toUser(addUserRequest));
        } catch (Exception e) {
            throw new ApplicationException("failed to create user " + e.getMessage());
        }

        return "user created with user id : " + user.getId();
    }

    public User getUser(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) throw new ApplicationException("user dose not exist");
        return userOptional.get();
    }

    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
