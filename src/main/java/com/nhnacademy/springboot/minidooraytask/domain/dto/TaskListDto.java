package com.nhnacademy.springboot.minidooraytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskListDto {
    private Integer taskId;
    private String subject;
    private String status;
    private String taskManagerId;
}