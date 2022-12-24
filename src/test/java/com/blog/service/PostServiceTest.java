package com.blog.service;

import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.dto.request.post.PostCreateRequest;
import com.blog.dto.request.user.UserCreateRequest;
import com.blog.dto.response.post.PostResponse;
import com.blog.dto.response.user.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;


    User user;

    @BeforeEach
    void init() {
        this.user = createUser();
    }

    @Test
    @Transactional
    void 게시글_조회() {
        Post post = postService.create(user, createPostCreateRequest());
        Post findPost = postService.findById(post.getId());

        assertThat(findPost.getId()).isEqualTo(post.getId());
        assertThat(findPost.getTitle()).isEqualTo("title-test");
    }

    @Test
    @Transactional
    void 게시글_작성() {
        Post post = postService.create(user, createPostCreateRequest());
        Post findPost = postService.findById(post.getId());
        assertThat(post.getId()).isEqualTo(findPost.getId());
    }

    private PostCreateRequest createPostCreateRequest() {
        return new PostCreateRequest("title-test", "content-test");
    }

    private User createUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setName("sample user1");
        userCreateRequest.setEmail("sample email1");
        userCreateRequest.setPassword("user1!");

        return userService.create(userCreateRequest);
    }
}