package com.blog.repository;

import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void 회원가입() {
        //given
        User user = createUser("user1", "user1@gmail.com");

        //when
        long savedId = userRepository.save(user);

        //then
        assertThat(savedId).isEqualTo(user.getId());
    }

    @Test
    @Transactional
    public void 회원단건조회() throws Exception {
        //given
        User user = createUser("user1", "user1@gmail.com");

        //when
        userRepository.save(user);
        User findUser = userRepository.findById(1L);

        //then
        assertThat(findUser.getId()).isEqualTo(user.getId());
    }

    private User createUser(String name, String email) {
        UserCreateCommand userCreateCommand = UserCreateCommand.builder()
                .name(name)
                .email(email)
                .build();

        User user = User.createUser(userCreateCommand);
        return user;
    }


}