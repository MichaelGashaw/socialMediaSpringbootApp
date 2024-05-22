package com.binary.socialmediaapp.repository;

import com.binary.socialmediaapp.model.Comment;
import com.binary.socialmediaapp.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();

    public PostRepository() {
        Post post1 = new Post();
        post1.setId(1);
        post1.setTitle("Hello Spring MVC");
        post1.setDescription("Starting SpringMVC");
        post1.setBody("Spring is so fun");

        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setAuthor("John Doe");
        comment1.setContent("Great post!");
        comment1.setCreatedOn(LocalDateTime.now());

        Comment comment2 = new Comment();
        comment2.setId(2);
        comment2.setAuthor("Jane Smith");
        comment2.setContent("Thanks for the information.");
        comment2.setCreatedOn(LocalDateTime.now());

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        post1.setComments(comments);

        Post post2 = new Post();
        post2.setId(2);
        post2.setTitle("Hey let's go to movie");
        post2.setDescription("Lord of the Ring");
        post2.setBody("Good movies");

        Post post3 = new Post();
        post3.setId(3);
        post3.setTitle("Let's Party");
        post3.setDescription("Do on Sunday");
        post3.setBody("Plan it");

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Optional<Post> findPostById(Integer id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public void updatePost(Integer id, Post updatedPost) {
        findPostById(id).ifPresent(post -> {
            post.setTitle(updatedPost.getTitle());
            post.setDescription(updatedPost.getDescription());
            post.setBody(updatedPost.getBody());
            post.setPostStatus(updatedPost.getPostStatus());
            post.setUpdatedOn(LocalDateTime.now());
        });
    }

    public void deletePost(Integer id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
}
