package com.blog.dto.response.likepost;

import com.blog.domain.LikePost;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UnlikePostResponse {

    private Long id;
    private Long postId;
    private Long userId;
    private String messages;

    public static UnlikePostResponse of(LikePost unlikePost) {
        return new UnlikePostResponse(
                unlikePost.getId(),
                unlikePost.getPost().getId(),
                unlikePost.getUser().getId(),
                "좋아요 취소 성공"
        );
    }
}
