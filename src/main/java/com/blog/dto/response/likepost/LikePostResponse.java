package com.blog.dto.response.likepost;

import com.blog.domain.LikePost;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LikePostResponse {

    private Long id;
    private Long postId;
    private Long userId;
    private String messages;

    public static LikePostResponse of(LikePost likePost) {
        return new LikePostResponse(
                likePost.getId(),
                likePost.getPost().getId(),
                likePost.getUser().getId(),
                "좋아요 성공"
        );
    }
}
