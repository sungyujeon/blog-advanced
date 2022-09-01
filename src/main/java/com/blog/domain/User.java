package com.blog.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@Getter
public class User {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;


}
