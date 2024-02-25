package com.nhnacademy.springboot.minidooraytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskDto {
    private String subject;
    private String status;
    private String taskManagerId;
    private MilestoneName milestone;
    private List<TaskTagName> tags;
    private List<CommentDto> comments;
}

