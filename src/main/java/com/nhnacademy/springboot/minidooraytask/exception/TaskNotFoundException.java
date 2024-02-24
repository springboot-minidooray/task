package com.nhnacademy.springboot.minidooraytask.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Integer taskId) {
    }
}
