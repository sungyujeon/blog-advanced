package com.blog.domain;

import com.blog.domain.command.UserCreateCommand;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static User createUser(UserCreateCommand command) {
        User user = new User();
        user.name = command.getName();
        user.email = command.getEmail();
        user.password = command.getPassword();
        user.createdAt = ZonedDateTime.now();
        user.modifiedAt = ZonedDateTime.now();

        return user;
    }
}
