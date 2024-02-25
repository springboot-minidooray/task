package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Tag;
import com.nhnacademy.springboot.minidooraytask.domain.Task;
import com.nhnacademy.springboot.minidooraytask.domain.TaskTag;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TaskTagResponse;
import com.nhnacademy.springboot.minidooraytask.exception.TagNotFoundException;
import com.nhnacademy.springboot.minidooraytask.exception.TaskNotFoundException;
import com.nhnacademy.springboot.minidooraytask.repository.TaskRepository;
import com.nhnacademy.springboot.minidooraytask.repository.TaskTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskTagService {
    private final TaskTagRepository taskTagRepository;
    private final TaskRepository taskRepository;
    private final TagService tagService;

    public List<TaskTagResponse> getTaskTags(Long projectId, Integer taskId) {
        return taskTagRepository.findAllByTaskId(taskId);
    }

    public TaskTagResponse createTaskTag(Long projectId, Integer taskId, Long tagId) {
        TaskTag taskTag = new TaskTag();
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        Tag tag = tagService.getTag(projectId, tagId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }
        if (tag == null) {
            throw new TagNotFoundException(tagId);
        }
        TaskTag.Pk pk = new TaskTag.Pk(optionalTask.get(), tag);
        taskTag.setPk(pk);
        return new TaskTagResponse(taskTag.getPk().getTask().getTaskId(), taskTag.getPk().getTag().getTagId());
    }

    public void deleteTaskTag(Long projectId, Integer taskId,Long tagId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        Tag tag = tagService.getTag(projectId, tagId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }
        if (tag == null) {
            throw new TagNotFoundException(tagId);
        }
        TaskTag.Pk pk = new TaskTag.Pk(optionalTask.get(), tag);

        taskTagRepository.deleteById(pk);
    }
}
