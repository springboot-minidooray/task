package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.TaskTag;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskTagResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTag.Pk> {

    @Query("select tt from TaskTag tt where tt.pk.task.taskId= : taskId")
    List<TaskTagResponse> findAllByTaskId(@Param("taskId") Integer taskId);

    @Query("select tt from TaskTag tt join tt.pk.task t join t.comments c where t.project.projectId=:projectId and tt.pk.task.taskId=:taskId and c.task.taskId=:taskId")
    TaskDto getTask(@Param("projectId") Long projectId, @Param("taskId") Integer taskId);
}
