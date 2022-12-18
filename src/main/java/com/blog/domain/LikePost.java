package com.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "LIKE_POST")
@Getter
public class LikePost extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
