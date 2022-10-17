package com.blog.service;

import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.dto.request.post.PostCreateRequest;
import com.blog.dto.response.post.PostResponse;
import com.blog.repository.PostRepository;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponse findById(Long postId) {
        Post post = find(postId);
        return PostResponse.of(post);
    }

    @Transactional
    public PostResponse create(Long userId, PostCreateRequest request) {
        Post post = createPost(userId, request);
        return PostResponse.of(post);
    }

    protected Post find(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글"));
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));
    }

    protected Post createPost(Long userId, PostCreateRequest request) {
        User user = getUser(userId);
        Post post = new Post(user, request.getTitle(), request.getContent());
        return postRepository.save(post);
    }
}