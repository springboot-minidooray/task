package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.Task;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<TaskResponseDto> findAllByProject_projectId(Long projectId);

    TaskResponseDto findByProject_ProjectIdAndTaskId(Long projectId, Integer taskId);
}
