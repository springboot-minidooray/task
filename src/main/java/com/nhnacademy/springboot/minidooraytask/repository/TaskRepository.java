package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.Task;
import com.nhnacademy.springboot.minidooraytask.domain.dto.ProjectWithTask;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<TaskListDto> findAllByProject_projectId(Long projectId);

    @Query("select t from Task t inner join TaskTag tt inner join Comment c where t.project.projectId=:projectId and tt.pk.task.taskId=:taskId and c.task.taskId=:taskId")
    Task getTask(@Param("projectId")Long projectId, @Param("taskId") Integer taskId);

}
