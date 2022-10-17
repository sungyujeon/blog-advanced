package com.blog.controller;

import com.blog.dto.request.post.PostCreateRequest;
import com.blog.dto.response.post.PostResponse;
import com.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<PostResponse> save(@RequestBody PostCreateRequest request) {
        PostResponse response = postService.create(1L, request);
        return ResponseEntity.ok(response);
    }

}
