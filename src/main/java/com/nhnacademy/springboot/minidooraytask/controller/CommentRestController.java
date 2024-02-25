package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.domain.Comment;
import com.nhnacademy.springboot.minidooraytask.domain.dto.CommentModifyDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.CommentRegisterDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.CommentResponseDto;
import com.nhnacademy.springboot.minidooraytask.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tasks/{taskId}/comments")
public class CommentRestController {
    private final CommentService commentService;

    @GetMapping
    public List<Comment> getComments(@PathVariable Long projectId, @PathVariable Integer taskId) {
        return commentService.getComments(taskId);
    }

    @PostMapping
    public CommentResponseDto createComment(@PathVariable Long projectId, @PathVariable Integer taskId, @RequestBody CommentRegisterDto commentRegisterDto) {
        return commentService.createComment(taskId, commentRegisterDto);
    }

    @PutMapping("/{commentId}")
    public CommentResponseDto modifyComment(@PathVariable Long projectId, @PathVariable Integer taskId, @PathVariable Integer commentId, @RequestBody CommentModifyDto commentModifyDto) {
        return commentService.modifyComment(commentId, commentModifyDto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long projectId, @PathVariable Integer taskId, @PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("deleted comment");
    }
}
