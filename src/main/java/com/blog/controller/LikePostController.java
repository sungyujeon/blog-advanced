package com.blog.controller;

import com.blog.domain.LikePost;
import com.blog.domain.User;
import com.blog.dto.request.likepost.LikePostRequest;
import com.blog.dto.response.likepost.LikePostResponse;
import com.blog.dto.response.likepost.UnlikePostResponse;
import com.blog.service.LikePostService;
import com.blog.service.UserService;
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
        return ResponseEntity.ok(LikePostResponse.of(likePost));
    }

    @PostMapping("/unlike")
    public ResponseEntity<UnlikePostResponse> postUnlike(@PathVariable("postId") Long postId, @RequestBody LikePostRequest request) {
        LikePost unlikePost = likePostService.unlike(request.getLikePostId());
        return ResponseEntity.ok(UnlikePostResponse.of(unlikePost));
    }

    private User findUser() {
        return userService.findById(1L);
    }
}
