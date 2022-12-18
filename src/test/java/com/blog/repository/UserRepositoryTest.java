package com.blog.repository;

import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Mock
    private UserRepository mockedUserRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void 회원가입() {
        //given
        User user = createUser("name1", "name1@gmail.com");

        User savedUser = userRepository.save(user);

        assertThat(savedUser.getId()).isEqualTo(user.getId());

//        List<User> all = mockedUserRepository.findAll();
//        all.stream().forEach(System.out::println);
//        User any = any(User.class);
//        System.out.println("any = " + any);


        //when
//        User savedUser = userRepository.save(any);

        //then
//        assertThat(savedUser.getId()).isEqualTo(any.getId());
    }

    @Test
    @Transactional
    public void 회원단건조회() throws Exception {
//        //given
//        User user = createUser("user1", "user1@gmail.com");
//
//        //when
//        userRepository.save(user);
//        User findUser = userRepository.findById(1L);
//
//        //then
//        assertThat(findUser.getId()).isEqualTo(user.getId());
    }

    private User createUser(String name, String email) {
        UserCreateCommand userCreateCommand = UserCreateCommand.builder()
                .name(name)
                .email(email)

                .createAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        return User.createUser(userCreateCommand);
    }


}