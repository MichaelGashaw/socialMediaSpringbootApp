package com.binary.socialmediaapp.controller;

import com.binary.socialmediaapp.model.Post;
import com.binary.socialmediaapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping({"", "/list", "/postslist"})
    public String postPage(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return "posts/postIndex";
    }

    @GetMapping("/create")
    public String createPostPage(Model model){
        model.addAttribute("newPost", new Post());
        return "posts/createPostPage";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post newPost){
        postService.addPost(newPost);
        return "redirect:/posts/list";
    }

    @GetMapping("/edit/{id}")
    public String editPostPage(@PathVariable("id") Integer id, Model model){
        Post post = postService.findPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "posts/editPostPage";
        }
        return "redirect:/posts/list";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable("id") Integer id, @ModelAttribute Post updatedPost){
        postService.updatePost(id, updatedPost);
        return "redirect:/posts/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id){
        postService.deletePost(id);
        return "redirect:/posts/list";
    }
}
