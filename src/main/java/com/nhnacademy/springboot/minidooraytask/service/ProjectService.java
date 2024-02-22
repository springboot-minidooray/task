package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Project;
import com.nhnacademy.springboot.minidooraytask.domain.dto.ProjectModifyDto;
import com.nhnacademy.springboot.minidooraytask.exception.ProjectNotfoundException;
import com.nhnacademy.springboot.minidooraytask.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isPresent()) {
            return project.get();
        } else {
            throw new ProjectNotfoundException(projectId);
        }
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project modifyProject(Long projectId, ProjectModifyDto projectModifyDto) {
        if (projectRepository.existsById(projectId)) {
            Project project = projectRepository.findById(projectId).get();
            project.setProjectName(projectModifyDto.getProjectName());
            project.setProjectStatus(projectModifyDto.getProjectStatus());
            return projectRepository.save(project);
        } else {
            throw new ProjectNotfoundException(projectId);
        }
    }

    public void deleteProject(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotfoundException(projectId);
        }
        projectRepository.deleteById(projectId);
    }


}
