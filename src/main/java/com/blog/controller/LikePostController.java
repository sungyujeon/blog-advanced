package com.blog.controller;

import com.blog.domain.LikePost;
import com.blog.domain.User;
import com.blog.dto.request.likepost.LikePostRequest;
import com.blog.dto.response.likepost.LikePostResponse;
import com.blog.service.LikePostService;
import com.blog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/{postId}")
@RestController
@RequiredArgsConstructor
public class LikePostController {

    private final LikePostService likePostService;
    private final UserService userService;

    @PostMapping("/like")
    public ResponseEntity<LikePostResponse> postLike(@PathVariable("postId") Long postId) {
        LikePost likePost = likePostService.like(findUser(), postId);
        log.info("={}", LikePostResponse.of(likePost));
        return ResponseEntity.ok(LikePostResponse.of(likePost));
    }

    @PostMapping("/unlike")
    public void postUnlike(@PathVariable("postId") Long postId, @RequestBody LikePostRequest request) {
        likePostService.unlike(request.getLikePostId());
    }

    private User findUser() {
        return userService.findById(1L);
    }
}
