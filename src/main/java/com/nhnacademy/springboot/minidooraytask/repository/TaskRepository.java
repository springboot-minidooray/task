package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.Task;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskListDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<TaskListDto> findAllByProject_projectId(Long projectId);

    TaskListDto findByProject_ProjectIdAndTaskId(Long projectId, Integer taskId);
}
