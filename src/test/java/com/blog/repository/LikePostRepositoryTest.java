package com.blog.repository;

import com.blog.domain.LikePost;
import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.domain.command.UserCreateCommand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class LikePostRepositoryTest {

    @Autowired LikePostRepository likePostRepository;
    @Autowired PostRepository postRepository;
    @Autowired UserRepository userRepository;

    User user;
    Post post;

    @BeforeEach
    void init() {
        UserCreateCommand userCommand = UserCreateCommand.builder()
                .name("defaultUser")
                .email("defaultUser@gmail.com")
                .password("user1!")
                .build();
        user = User.createUser(userCommand);
        userRepository.save(user);
        postRepository.save(new Post(user, "sample title", "sample content"));
    }

    @Test
    @Transactional
    void 게시글_좋아요_조회() {
        LikePost likePost = likePostRepository.save(new LikePost(user, post));

        LikePost findLikePost = likePostRepository.findLike(user.getId(), post.getId());

        assertThat(findLikePost.getPost()).isEqualTo(likePost.getPost());
        assertThat(findLikePost.getUser()).isEqualTo(likePost.getUser());
        assertThat(findLikePost.getId()).isEqualTo(likePost.getId());
    }

}