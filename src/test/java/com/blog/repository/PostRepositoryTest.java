package com.blog.repository;

import com.blog.domain.Post;
import com.blog.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Transactional
    public void testPost() {
        //given
        User user = new User();
        user.setName("user1");

        Post post = new Post();
        post.setUser(user);
        post.setTitle("title1");
        post.setContent("content1");

        //when
        Long savedId = postRepository.save(post);
        Post findPost = postRepository.find(savedId);

        //then
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(findPost.getContent()).isEqualTo(post.getContent());
        assertThat(findPost.getUser().getName()).isEqualTo(user.getName());
    }

}