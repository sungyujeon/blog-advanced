package com.blog.service;

import com.blog.domain.LikePost;
import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.repository.LikePostRepository;
import com.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikePostService {

    private final LikePostRepository likePostRepository;
    private final PostRepository postRepository;

    public LikePost findById(Long likePostId) {
        return likePostRepository.findById(likePostId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글 좋아요"));
    }

    @Transactional
    public Optional<LikePost> like(User user, Long postId) {
        LikePost likePost = likePostRepository.findLike(user.getId(), postId);
        if (likePost == null) {
            Post post = postRepository.findById(postId).get();
            return Optional.of(likePostRepository.save(new LikePost(user, post)));
        }
        return Optional.empty();
    }

    @Transactional
    public void unlike(Long likePostId) {
        Optional<LikePost> likePostOptional = likePostRepository.findById(likePostId);
        if (likePostOptional.isPresent()) {
            likePostRepository.delete(findById(likePostId));
        }
    }
}
