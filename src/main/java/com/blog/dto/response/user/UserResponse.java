package com.blog.dto.response.user;

import com.blog.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt());
    }
}
