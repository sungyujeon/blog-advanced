package com.blog.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreateRequest {

    private String name;
    private String email;
    private String password;
}
