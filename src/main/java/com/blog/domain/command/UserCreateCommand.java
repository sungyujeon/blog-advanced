package com.blog.domain.command;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCreateCommand {

    private String name;
    private String email;
    private String password;
}
