package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.domain.Project;
import com.nhnacademy.springboot.minidooraytask.domain.dto.ProjectModifyDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.ProjectRegisterDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.ProjectWithTask;
import com.nhnacademy.springboot.minidooraytask.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectRestController {
    private final ProjectService projectService;

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/user/{userId}")
    public List<Project> getProjects(@PathVariable String userId) {
        return projectService.getProjects(userId);
    }

    @GetMapping("/{projectId}")
    public ProjectWithTask getProject(@PathVariable Long projectId) {
        return projectService.getProject(projectId);
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectRegisterDto projectRegisterDto) {
        return projectService.createProject(projectRegisterDto);
    }

    @PutMapping("/{projectId}")
    public Project modifyProject(@PathVariable Long projectId, @RequestBody ProjectModifyDto projectDto) {
        return projectService.modifyProject(projectId, projectDto);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Long projectId) {
        try {
            projectService.deleteProject(projectId);
            return ResponseEntity.ok("project deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error deleting project");
        }
    }

}
