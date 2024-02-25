package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Milestone;
import com.nhnacademy.springboot.minidooraytask.domain.Project;
import com.nhnacademy.springboot.minidooraytask.domain.Task;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskModifyDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskRegisterDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskListDto;
import com.nhnacademy.springboot.minidooraytask.exception.MilestoneNotFountException;
import com.nhnacademy.springboot.minidooraytask.exception.ProjectNotFoundException;
import com.nhnacademy.springboot.minidooraytask.exception.TaskNotFoundException;
import com.nhnacademy.springboot.minidooraytask.repository.MilestoneRepository;
import com.nhnacademy.springboot.minidooraytask.repository.ProjectRepository;
import com.nhnacademy.springboot.minidooraytask.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;

    public List<TaskListDto> getTasks(Long projectId) {
        return taskRepository.findAllByProject_projectId(projectId);
    }

    public TaskListDto getTask(Long projectId, Integer taskId) {
        return taskRepository.findByProject_ProjectIdAndTaskId(projectId, taskId);
    }

    public TaskListDto createTask(Long projectId, TaskRegisterDto taskRegisterDto) {
        Task task = new Task();
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isEmpty()) {
            throw new ProjectNotFoundException(projectId);
        }
        Optional<Milestone> milestone = milestoneRepository.findById(taskRegisterDto.getMilestoneId());
        if (milestone.isEmpty()){
            throw new MilestoneNotFountException(taskRegisterDto.getMilestoneId());
        }
        task.setProject(project.get());
        task.setTaskManagerId(taskRegisterDto.getTaskManagerId());
        task.setMilestone(milestone.get());
        task.setSubject(taskRegisterDto.getSubject());
        task.setContents(taskRegisterDto.getContents());
        task.setStatus(taskRegisterDto.getStatus());

        Task responseTask = taskRepository.save(task);
        return new TaskListDto(
                responseTask.getTaskId(),
                responseTask.getSubject(),
                responseTask.getStatus(),
                responseTask.getTaskManagerId()
        );
    }

    public TaskListDto modifyTask(Integer taskId, TaskModifyDto taskModifyDto) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        Task task = optionalTask.get();
        task.setTaskManagerId(taskModifyDto.getTaskManagerId());
        task.setSubject(taskModifyDto.getSubject());
        task.setContents(taskModifyDto.getContents());
        task.setStatus(task.getStatus());

        taskRepository.save(task);
        return new TaskListDto(
                task.getTaskId(),
                task.getSubject(),
                task.getStatus(),
                task.getTaskManagerId()
        );
    }

    public ResponseEntity<String> deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
        return ResponseEntity.ok("deleted task");
    }
}
