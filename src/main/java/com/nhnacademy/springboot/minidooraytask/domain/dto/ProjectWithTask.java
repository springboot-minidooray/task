package com.nhnacademy.springboot.minidooraytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectWithTask {
    private String projectName;
    private String projectManagerId;
    private List<TaskListDto> tasks;
    private String status;
    
    
}
