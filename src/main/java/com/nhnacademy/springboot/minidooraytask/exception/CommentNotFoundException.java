package com.nhnacademy.springboot.minidooraytask.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Integer commentId) {
    }
}
