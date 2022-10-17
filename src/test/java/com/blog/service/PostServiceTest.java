package com.blog.service;

import com.blog.domain.Post;
import com.blog.dto.request.post.PostCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    @Transactional
    void 게시글_조회() {
        Post findPost = postService.find(7L);
        assertThat(findPost.getId()).isEqualTo(7L);
    }

    @Test
    @Transactional
    void 게시글_작성() {
        Post createdPost = postService.createPost(1L, createPostCreateRequest());

        Post findPost = postService.find(createdPost.getId());

        assertThat(createdPost.getId()).isEqualTo(findPost.getId());
    }

    private PostCreateRequest createPostCreateRequest() {
        return new PostCreateRequest("title-test", "content-test");
    }

}