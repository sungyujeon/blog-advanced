package com.blog.service;

import com.blog.domain.Post;
import com.blog.dto.response.post.PostResponse;
import com.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public PostResponse findById(Long postId) {
        Post post = find(postId);
        return PostResponse.of(post);
    }

    protected Post find(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글"));
    }
}