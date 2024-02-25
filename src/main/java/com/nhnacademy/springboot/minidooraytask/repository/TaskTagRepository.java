package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.TaskTag;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskTagResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTag.Pk> {
    List<TaskTagResponse> findAllPk_Task_TaskIdAndPk_Task_Project_ProjectId(Integer taskId, Long projectId);
}
