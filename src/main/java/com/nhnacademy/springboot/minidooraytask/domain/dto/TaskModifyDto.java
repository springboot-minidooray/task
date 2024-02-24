package com.nhnacademy.springboot.minidooraytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskModifyDto {
    private String taskManagerId;
    private String subject;
    private String contents;
    private String status;
}
