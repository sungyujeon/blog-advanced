//package com.blog.repository;
//
//import com.blog.domain.Comment;
//import com.blog.domain.Post;
//import com.blog.domain.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.*;
//
//@SpringBootTest
//class CommentRepositoryTest {
//
//    @Autowired
//    CommentRepository commentRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    PostRepository postRepository;
//
//    @Test
//    @Transactional
//    public void testComment() {
//        //given
//        User user = createUser("user1");
//        Post post = createPost(user, "title1", "content1");
//
//        Comment comment = new Comment();
//        comment.setUser(post.getUser());
//        comment.setPost(post);
//        comment.setContent("comment1");
//
//        //when
//        commentRepository.save(comment);
////        Comment findComment = commentRepository.find(savedId);
//
//        //then
////        assertThat(findComment.getContent()).isEqualTo(comment.getContent());
//    }
//
//    private User createUser(String name) {
//        User user = new User();
//        user.setName(name);
//        userRepository.save(user);
//
//        return user;
//    }
//
//    private Post createPost(User user, String title, String content) {
//        Post post = new Post();
//        post.setUser(user);
//        post.setTitle(title);
//        post.setContent(content);
//        postRepository.save(post);
//
//        return post;
//    }
//
//}
