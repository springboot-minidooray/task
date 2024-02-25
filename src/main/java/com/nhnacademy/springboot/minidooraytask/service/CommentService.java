package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Comment;
import com.nhnacademy.springboot.minidooraytask.domain.Task;
import com.nhnacademy.springboot.minidooraytask.domain.dto.CommentModifyDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.CommentRegisterDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.CommentResponseDto;
import com.nhnacademy.springboot.minidooraytask.exception.CommentNotFoundException;
import com.nhnacademy.springboot.minidooraytask.exception.TaskNotFoundException;
import com.nhnacademy.springboot.minidooraytask.repository.CommentRepository;
import com.nhnacademy.springboot.minidooraytask.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public List<Comment> getComments(Integer taskId) {
        return commentRepository.findAllByTask_TaskId(taskId);
    }

    public CommentResponseDto createComment(Integer taskId, CommentRegisterDto commentRegisterDto) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }
        Comment comment = new Comment();
        comment.setTask(task.get());
        comment.setWriterId(commentRegisterDto.getWriterId());
        comment.setContents(commentRegisterDto.getContents());

        comment = commentRepository.save(comment);

        return new CommentResponseDto(comment.getTask().getTaskId(), comment.getWriterId(), comment.getContents());
    }

    public CommentResponseDto modifyComment(Integer commentId, CommentModifyDto commentModifyDto) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isEmpty()) {
            throw new CommentNotFoundException(commentId);
        }

        Comment comment = optionalComment.get();
        comment.setContents(commentModifyDto.getContents());
        comment = commentRepository.save(comment);

        return new CommentResponseDto(comment.getTask().getTaskId(), comment.getWriterId(), comment.getContents());
    }

    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
