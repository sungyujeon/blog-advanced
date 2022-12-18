package com.blog.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor  // 필드값 모두 받는 생성자
@NoArgsConstructor  // 기본생성자
public class JoinUserRequest {

    private String name;

}
