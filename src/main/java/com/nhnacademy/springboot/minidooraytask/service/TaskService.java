package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Milestone;
import com.nhnacademy.springboot.minidooraytask.domain.Project;
import com.nhnacademy.springboot.minidooraytask.domain.Task;
import com.nhnacademy.springboot.minidooraytask.domain.dto.*;
import com.nhnacademy.springboot.minidooraytask.exception.MilestoneNotFountException;
import com.nhnacademy.springboot.minidooraytask.exception.ProjectNotFoundException;
import com.nhnacademy.springboot.minidooraytask.exception.TaskNotFoundException;
import com.nhnacademy.springboot.minidooraytask.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;
    private final TaskTagRepository taskTagRepository;

    public List<TaskListDto> getTasks(Long projectId) {
        return taskRepository.findAllByProject_projectId(projectId);
    }

    public TaskDto getTask(Long projectId, Integer taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        Task task = optionalTask.get();

        MilestoneName milestoneName = null;
        if(task.getMilestone() != null) {
            milestoneName = milestoneRepository.findByMilestoneId(task.getMilestone().getMilestoneId());
        }
        List<TaskTagName> taskTagNames = taskTagRepository.findAllByTaskId(taskId).stream().map(taskTag -> new TaskTagName(taskTag.getPk().getTag().getTagName())).collect(Collectors.toList());
        List<CommentDto> commentDto = task.getComments().stream().map(comment -> new CommentDto(comment.getCommentId(), comment.getWriterId(), comment.getContents())).collect(Collectors.toList());

        return new TaskDto(task.getSubject(), task.getStatus(), task.getTaskManagerId(), milestoneName, taskTagNames, commentDto);
    }

    public TaskListDto createTask(Long projectId, TaskRegisterDto taskRegisterDto) {
        Task task = new Task();
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isEmpty()) {
            throw new ProjectNotFoundException(projectId);
        }
        if (taskRegisterDto.getMilestoneId() != null) {
            Optional<Milestone> milestone = milestoneRepository.findById(taskRegisterDto.getMilestoneId());
            task.setMilestone(milestone.get());
        }
        task.setProject(project.get());
        task.setTaskManagerId(taskRegisterDto.getTaskManagerId());
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
