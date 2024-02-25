package com.nhnacademy.springboot.minidooraytask.domain.dto;

import com.nhnacademy.springboot.minidooraytask.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskTagResponse {
    Integer taskId;
    Long tagId;
}
