package com.blog.service;

import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import com.blog.dto.request.user.UserCreateRequest;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));
    }

    @Transactional
    public User create(UserCreateRequest request) {
        UserCreateCommand userCommand = UserCreateCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        log.info("userCommand", userCommand);

        User user = User.createUser(userCommand);
        userRepository.save(user);
        return user;
    }

}
