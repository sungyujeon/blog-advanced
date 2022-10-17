package com.blog.controller;

import com.blog.dto.response.post.PostResponse;
import com.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/post")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> findById(@PathVariable(value = "postId") Long postId) {
        PostResponse response = postService.findById(postId);
        return ResponseEntity.ok(response);
    }

}
