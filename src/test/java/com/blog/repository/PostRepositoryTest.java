package com.blog.repository;

import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void testPost() {
        //given
        User user = User.createUser(UserCreateCommand.builder().build());

        Post post = new Post(user, "title", "content");

        //when
        Post savedPost = postRepository.save(post);

        //then
        assertThat(savedPost.getTitle()).isEqualTo(post.getTitle());
    }

}