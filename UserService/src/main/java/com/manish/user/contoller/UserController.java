package com.manish.user.contoller;

import com.manish.user.dto.AddUserRequest;
import com.manish.user.entity.User;
import com.manish.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/user/add")
    public ResponseEntity<String> addUser(@RequestBody AddUserRequest addUserRequest) {
        return new ResponseEntity<>(userService.addUser(addUserRequest), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/api/v1/user")
    public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
        return new ResponseEntity<>(userService.getAllUser(pageable), HttpStatus.OK);
    }
}
