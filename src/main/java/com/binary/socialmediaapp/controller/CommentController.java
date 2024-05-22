package com.binary.socialmediaapp.controller;

import com.binary.socialmediaapp.model.Comment;
import com.binary.socialmediaapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/create/{postId}")
    public String createCommentPage(@PathVariable("postId") Integer postId, Model model){
        model.addAttribute("newComment", new Comment());
        model.addAttribute("postId", postId);
        return "comments/createCommentPage";
    }

    @PostMapping("/create/{postId}")
    public String createComment(@PathVariable("postId") Integer postId, @ModelAttribute Comment newComment){
        commentService.addComment(postId, newComment);
        return "redirect:/posts/list";
    }

    @GetMapping("/delete/{postId}/{commentId}")
    public String deleteComment(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId){
        commentService.deleteComment(postId, commentId);
        return "redirect:/posts/list";
    }
}
