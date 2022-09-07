package com.blog.repository;

import com.blog.domain.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Comment comment) {
        em.persist(comment);
        return comment.getId();
    }

    public Comment find(Long id) {
        return em.find(Comment.class, id);
    }


}
