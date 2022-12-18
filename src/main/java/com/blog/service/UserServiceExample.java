package com.blog.service;

import com.blog.controller.JoinUserRequest;
import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class UserServiceExample {

    private final UserRepository userRepository;

    public User findById(long userId) {  // 예외처리의 두가지 방법 service/repository or service all
//        User user = userRepository.findById(userId);

//        return user;
        return null;
    }

    @Transactional
    public long join(JoinUserRequest request) {
//        UserCreateCommand userCreateCommand = UserCreateCommand.builder()  //command pattern  cqrs..? R(90%) & cud(command)
//                .name(request.getName())
//                .build();
//        User user = User.createUser(userCreateCommand);
////        user.addAge(); // user의 값(age)이 변경  >> persistence에 캐싱이될거란 말이지...? 근데 read only query X, 영속성 컨텍스트 <-> persistence 일치가 안되자나
//        // 개발자가 신경써서 command 작업을 하지 말아야 된다는 뜻?
//        userRepository.save(user);
//
//        return user.getId();
        return 1L;
    }

    @Transactional
    public void afterNewYear(long userId) {
//        User user = userRepository.findById(userId);
    }
}
