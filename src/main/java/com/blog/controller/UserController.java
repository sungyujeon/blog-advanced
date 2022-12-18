package com.blog.controller;

import com.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user/{userId}")
    public void findById(@PathVariable(value = "userId") long userId) {
        userService.findById(userId);
    }

    @PostMapping("/api/user")
    public void joinUser(@RequestBody JoinUserRequest request) {
        userService.join(request);
    }

}
