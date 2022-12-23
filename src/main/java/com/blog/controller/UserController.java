package com.blog.controller;

import com.blog.domain.User;
import com.blog.dto.request.user.UserCreateRequest;
import com.blog.dto.response.user.UserResponse;
import com.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable(value = "userId") Long userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok(UserResponse.of(user));
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserCreateRequest request) {
        log.info("request=", request);
        User user = userService.create(request);
        return ResponseEntity.ok(UserResponse.of(user));
    }
}
