package com.binary.socialmediaapp.service;

import com.binary.socialmediaapp.model.Comment;
import com.binary.socialmediaapp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository repository;

    public void addComment(Integer postId, Comment comment) {
        repository.addComment(postId, comment);
    }

    public void deleteComment(Integer postId, Integer commentId) {
        repository.deleteComment(postId, commentId);
    }
}
