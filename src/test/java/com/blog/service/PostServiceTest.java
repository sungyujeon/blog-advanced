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

}