package com.nhnacademy.springboot.minidooraytask.exception;

import com.nhnacademy.springboot.minidooraytask.domain.Project;

public class ProjectAlreadyExistException extends RuntimeException {
    public ProjectAlreadyExistException(Project project) {
        super("project already exist : " +project.toString());
    }
}
