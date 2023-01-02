package com.blog.service;

import com.blog.domain.LikePost;
import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.dto.request.post.PostCreateRequest;
import com.blog.dto.request.user.UserCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class LikePostServiceTest {

    @Autowired LikePostService likePostService;
    @Autowired PostService postService;
    @Autowired UserService userService;

    static User user;
    static Post post;

    @BeforeEach
    void init() {
        user = userService.create(new UserCreateRequest("sample name", "sample email", "password!"));
        post = postService.create(user, new PostCreateRequest("sample title", "sample content"));
    }

    @Test
    @Transactional
    void 좋아요_내역_존재시_조회() {
        LikePost likePost = likePostService.like(user, post.getId());
        LikePost findLikePost = likePostService.findById(likePost.getId());
        assertThat(findLikePost.getId()).isEqualTo(likePost.getId());
    }

    @Test
    @Transactional
    void 좋아요_내역_미존재시_조회() {
        assertThatThrownBy(() -> likePostService.findById(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는 게시글 좋아요");
    }

    @Test
    @Transactional
    void 좋아요() {
        for (int i = 0; i < 2; i++) {
            likePostService.like(user, post.getId());
        }

        List<LikePost> results = likePostService.findAll();

        assertThat(results.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    void 좋아요_내역_존재시_취소() {
        LikePost likePost = likePostService.like(user, post.getId());
        likePostService.unlike(likePost.getId());

        List<LikePost> results = likePostService.findAll();

        assertThat(results.size()).isEqualTo(0);
    }

    @Test
    @Transactional
    void 좋아요_내역_미존재시_취소() {
        assertThatThrownBy(() -> likePostService.unlike(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는 게시글 좋아요");
    }
}