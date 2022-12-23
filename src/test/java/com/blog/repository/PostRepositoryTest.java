package com.blog.repository;

import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {

    @Autowired PostRepository postRepository;
    @Autowired UserRepository userRepository;

    User user;

    @BeforeEach
    public void initEach() {
        UserCreateCommand userCommand = UserCreateCommand.builder()
                .name("defaultUser")
                .email("defaultUser@gmail.com")
                .password("user1!")
                .build();
        user = User.createUser(userCommand);
        userRepository.save(user);
    }

    @Test
    @Transactional
    public void create() {
        Post post = createPost();

        Post savedPost = postRepository.save(post);
        Optional<Post> findPost = postRepository.findById(savedPost.getId());

        assertThat(savedPost.getId()).isEqualTo(findPost.get().getId());
        assertThat(savedPost.getTitle()).isEqualTo(findPost.get().getTitle());
    }

    @Test
    @Transactional
    public void findById() {
        Post savedPost = postRepository.save(createPost());
        Optional<Post> findPost = postRepository.findById(savedPost.getId());
        assertThat(findPost.get().getTitle()).isEqualTo("title1");
    }

    @Test
    @Transactional
    public void findAll() {
        for (int i = 0; i < 3; i++) {
            postRepository.save(createPost());
        }
        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(3);
    }

    private Post createPost() {
        return new Post(user, "title1", "content1");
    }
}