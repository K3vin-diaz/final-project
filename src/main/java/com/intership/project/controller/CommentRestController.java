package com.intership.project.controller;

import com.intership.project.model.Comment;
import com.intership.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/item/{itemId}")
    public List<Comment> getCommentsByItemId(@PathVariable Long itemId) {
        return commentService.getCommentsByItemId(itemId);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}