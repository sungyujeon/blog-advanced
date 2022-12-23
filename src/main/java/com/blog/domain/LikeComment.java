package com.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "LIKE_COMMENT")
@Getter
public class LikeComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
