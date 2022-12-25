package com.blog.controller;

import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.dto.request.post.PostCreateRequest;
import com.blog.dto.response.post.PostResponse;
import com.blog.service.PostService;
import com.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/post")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> findById(@PathVariable(value = "postId") Long postId) {
        Post post = postService.findById(postId);
        return ResponseEntity.ok(PostResponse.of(post));
    }

    @PostMapping
    public ResponseEntity<PostResponse> save(@RequestBody PostCreateRequest request) {
        //TODO userId는 우선 1L을 세팅한다. 추후 userService를 통해 user 정보를 조회하여 넘긴다.
        Post post = postService.create(findUser(), request);
        return ResponseEntity.ok(PostResponse.of(post));
    }

    private User findUser() {
        return userService.findById(1L);
    }

}
