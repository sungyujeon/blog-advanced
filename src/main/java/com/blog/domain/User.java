package com.blog.domain;

import com.blog.domain.command.UserCreateCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    public static User createUser(UserCreateCommand command) {
        User user = new User();
        user.name = command.getName();
        user.email = command.getEmail();
        user.password = command.getPassword();
        user.createdAt = command.getCreateAt();
        user.modifiedAt = command.getModifiedAt();

        return user;
    }
}
