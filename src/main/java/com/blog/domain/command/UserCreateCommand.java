package com.blog.domain.command;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class UserCreateCommand {

    private String name;
    private String email;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
