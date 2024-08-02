package com.userService.userService.controller;

import com.userService.userService.dto.UserRegistrationRequest;
import com.userService.userService.dto.UserUpdateRequest;
import com.userService.userService.model.User;
import com.userService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class userController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Validated @RequestBody UserRegistrationRequest request) {
        User userDetails = new User();
        userDetails.setEmail(request.getEmail());
        userDetails.setMobile(request.getMobile());
        userDetails.setPassword(request.getPassword());
        User user = userService.registerUser(userDetails);
        return ResponseEntity.ok(userDetails);
    }
//    @PutMapping("/{userId}")
//    public ResponseEntity<User> updateUserDetails(
//            @PathVariable Long userId,
//            @RequestBody UserUpdateRequest request) {
//        User user = userService.updateUserDetails(userId, request.getEmail(), request.getMobile(), request.getPassword());
//        return ResponseEntity.ok(user);
//    }
}
