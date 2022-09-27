package com.blog.domain;

import com.blog.domain.command.UserCreateCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

}
