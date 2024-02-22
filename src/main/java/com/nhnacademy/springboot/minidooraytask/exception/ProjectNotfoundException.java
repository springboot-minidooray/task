package com.nhnacademy.springboot.minidooraytask.exception;

public class ProjectNotfoundException extends RuntimeException {
    public ProjectNotfoundException(Long id) {
        super("project not found : "+id);
    }
}
