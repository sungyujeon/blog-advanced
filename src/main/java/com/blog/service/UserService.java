package com.blog.service;

import com.blog.controller.JoinUserRequest;
import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findById(long userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public long join(JoinUserRequest request) {
        UserCreateCommand userCreateCommand = UserCreateCommand.builder()
                .name(request.getName())
                .build();

//        User user = User.createUser(userCreateCommand);
//        userRepository.save(user);

//        return user.getId();
        return 1L;
    }
}
