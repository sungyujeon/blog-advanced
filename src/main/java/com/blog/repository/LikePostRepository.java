package com.blog.repository;

import com.blog.domain.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {

    @Query("select lp from LikePost lp where lp.user.id = :userId and lp.post.id = :postId")
    LikePost findLike(@Param("userId") Long userId, @Param("postId") Long postId);
}
