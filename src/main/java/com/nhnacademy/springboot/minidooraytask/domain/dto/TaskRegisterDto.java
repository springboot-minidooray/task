package com.nhnacademy.springboot.minidooraytask.domain.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskRegisterDto {
    private String taskManagerId;

    private Long milestoneId;

    private String subject;

    private String contents;

    private String status;
}
