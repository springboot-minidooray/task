package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskModifyDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskRegisterDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskListDto;
import com.nhnacademy.springboot.minidooraytask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tasks")
public class TaskRestController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskListDto> getTasks(@PathVariable Long projectId) {
        return taskService.getTasks(projectId);
    }

    @GetMapping("/{taskId}")
    public TaskListDto getTask(@PathVariable Long projectId, @PathVariable Integer taskId) {
        return taskService.getTask(projectId, taskId);
    }

    @PostMapping
    public TaskListDto createTask(@PathVariable Long projectId, @RequestBody TaskRegisterDto taskRegisterDto) {
        return taskService.createTask(projectId, taskRegisterDto);
    }

    @PutMapping("/{taskId}")
    public TaskListDto modifyTask(@PathVariable Integer taskId, @RequestBody TaskModifyDto taskModifyDto) {
        return taskService.modifyTask(taskId, taskModifyDto);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer taskId) {
        return taskService.deleteTask(taskId);
    }
}
