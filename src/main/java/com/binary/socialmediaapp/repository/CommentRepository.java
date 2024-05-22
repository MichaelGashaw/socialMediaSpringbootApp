package com.binary.socialmediaapp.repository;

import com.binary.socialmediaapp.model.Comment;
import com.binary.socialmediaapp.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepository {
    private final PostRepository postRepository;

    public CommentRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addComment(Integer postId, Comment comment) {
        Optional<Post> optionalPost = postRepository.findPostById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            List<Comment> comments = getOrCreateCommentList(post);
            comment.setId(generateCommentId(comments));
            comment.setCreatedOn(LocalDateTime.now());
            comments.add(comment);
        }
    }

    public List<Comment> getComments(Integer postId) {
        return postRepository.findPostById(postId)
                .map(Post::getComments)
                .orElse(new ArrayList<>());
    }

    public Optional<Comment> getCommentById(Integer postId, Integer commentId) {
        return getComments(postId).stream()
                .filter(comment -> comment.getId().equals(commentId))
                .findFirst();
    }

    public void deleteComment(Integer postId, Integer commentId) {
        Optional<Post> optionalPost = postRepository.findPostById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            List<Comment> comments = post.getComments();
            if (comments != null) {
                comments.removeIf(comment -> comment.getId().equals(commentId));
            }
        }
    }

    private List<Comment> getOrCreateCommentList(Post post) {
        List<Comment> comments = post.getComments();
        if (comments == null) {
            comments = new ArrayList<>();
            post.setComments(comments);
        }
        return comments;
    }

    private int generateCommentId(List<Comment> comments) {
        return comments.isEmpty() ? 1 : comments.get(comments.size() - 1).getId() + 1;
    }
}
