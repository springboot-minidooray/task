package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.domain.dto.TagName;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskTagResponse;
import com.nhnacademy.springboot.minidooraytask.service.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tasks/{taskId}/tags")
public class TaskTagRestController {
    private final TaskTagService taskTagService;

    @GetMapping
    public List<TaskTagResponse> getTags(@PathVariable Long projectId, @PathVariable Integer taskId) {
        return taskTagService.getTaskTags(projectId, taskId);
    }

    @PostMapping
    public TaskTagResponse createTag(@PathVariable Long projectId, @PathVariable Integer taskId, @RequestBody Long tagId) {
        return taskTagService.createTaskTag(projectId, taskId, tagId);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<String> deleteTag(@PathVariable Long projectId, @PathVariable Integer taskId, @PathVariable Long tagId) {
        taskTagService.deleteTaskTag(projectId, taskId, tagId);
        return ResponseEntity.ok("deleted tag in task");
    }

}
