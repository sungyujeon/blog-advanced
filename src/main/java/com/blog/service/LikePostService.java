package com.blog.service;

import com.blog.domain.LikePost;
import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.repository.LikePostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikePostService {

    private final LikePostRepository likePostRepository;
    private final PostService postService;

    public LikePost findById(Long likePostId) {
        return likePostRepository.findById(likePostId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글 좋아요"));
    }

    @Transactional
    public LikePost like(User user, Long postId) {
        Post post = postService.findById(postId);
        LikePost likePost = new LikePost(user, post);
        return likePostRepository.save(likePost);
    }

    @Transactional
    public void unlike(Long likePostId) {
        likePostRepository.delete(findById(likePostId));
    }
}
