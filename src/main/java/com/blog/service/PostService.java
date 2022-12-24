package com.blog.service;

import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.dto.request.post.PostCreateRequest;
import com.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글"));
    }

    @Transactional
    public Post create(User user, PostCreateRequest request) {
        Post post = new Post(user, request.getTitle(), request.getContent());
        postRepository.save(post);
        return post;
    }

    @Transactional
    public void delete(Post post) {
        postRepository.delete(post);
    }
}