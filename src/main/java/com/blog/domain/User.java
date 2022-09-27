package com.blog.domain;

import com.blog.domain.command.UserCreateCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    public static User createUser(UserCreateCommand command) {
        User user = new User();
        user.name = command.getName();
        user.email = command.getEmail();
        user.password = command.getPassword();

        return user;
    }

}
