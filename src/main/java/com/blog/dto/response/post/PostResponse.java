package com.blog.dto.response.post;

import com.blog.domain.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
    private Long userId;

    public static PostResponse of(Post post) {
        return new PostResponse(post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getModifiedAt(),
                post.getUser().getId());
    }
}
