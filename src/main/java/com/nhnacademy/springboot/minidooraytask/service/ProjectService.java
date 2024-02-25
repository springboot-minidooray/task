package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Project;
import com.nhnacademy.springboot.minidooraytask.domain.dto.ProjectModifyDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.ProjectWithTask;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskListDto;
import com.nhnacademy.springboot.minidooraytask.exception.ProjectNotFoundException;
import com.nhnacademy.springboot.minidooraytask.repository.ProjectRepository;
import com.nhnacademy.springboot.minidooraytask.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public List<Project> getProjects(String userId) {
        return projectRepository.findAllByMemberId(userId);
    }

    public ProjectWithTask getProject(Long projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            List<TaskListDto> taskListDto = taskRepository.findAllByProject_projectId(projectId);
            return new ProjectWithTask(project.getProjectName(), project.getProjectManagerId(),taskListDto, project.getStatus());
        } else {
            throw new ProjectNotFoundException(projectId);
        }
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project modifyProject(Long projectId, ProjectModifyDto projectModifyDto) {
        if (projectRepository.existsById(projectId)) {
            Project project = projectRepository.findById(projectId).get();
            project.setProjectName(projectModifyDto.getProjectName());
            project.setStatus(projectModifyDto.getProjectStatus());
            return projectRepository.save(project);
        } else {
            throw new ProjectNotFoundException(projectId);
        }
    }

    public void deleteProject(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException(projectId);
        }
        projectRepository.deleteById(projectId);
    }


}
