package com.blog.dto.response.likepost;

import com.blog.domain.LikePost;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LikePostResponse {

    private Long id;
    private Long postId;
    private Long userId;

    private static final LikePostResponse EMPTY = new LikePostResponse();

    public static LikePostResponse of(LikePost likePost) {
        return new LikePostResponse(
                likePost.getId(),
                likePost.getPost().getId(),
                likePost.getUser().getId()
        );
    }

    public static LikePostResponse ofNullable(@Nullable LikePost likePost) {
        return likePost == null ? EMPTY : of(likePost);
    }
}
