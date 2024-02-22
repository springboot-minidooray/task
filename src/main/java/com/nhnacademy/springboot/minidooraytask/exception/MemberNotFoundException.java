package com.nhnacademy.springboot.minidooraytask.exception;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long projectId, String memberId) {
        super("member not found: projectId-" +projectId+ ", meberid-"+memberId);
    }
}
