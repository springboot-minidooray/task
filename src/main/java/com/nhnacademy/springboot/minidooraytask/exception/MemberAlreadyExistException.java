package com.nhnacademy.springboot.minidooraytask.exception;

public class MemberAlreadyExistException extends RuntimeException {
    public MemberAlreadyExistException(Long projectId, String memberId) {
        super("member already exist : projectId-"+projectId+", memberId-"+memberId);
    }
}
