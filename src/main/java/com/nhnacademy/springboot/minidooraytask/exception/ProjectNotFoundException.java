package com.nhnacademy.springboot.minidooraytask.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("project not found : "+id);
    }
}
