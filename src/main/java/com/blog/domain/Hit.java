package com.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Hit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private int count;

}
