package com.binary.socialmediaapp.service;

import com.binary.socialmediaapp.model.Post;
import com.binary.socialmediaapp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository repository;

    public void addPost(Post post) {
        repository.addPost(post);
    }

    public List<Post> findAllPosts() {
        return repository.getAllPosts();
    }

    public Post findPostById(Integer id) {
        return repository.findPostById(id).orElse(null);
    }

    public void updatePost(Integer id, Post updatedPost) {
        repository.updatePost(id, updatedPost);
    }

    public void deletePost(Integer id) {
        repository.deletePost(id);
    }
}
