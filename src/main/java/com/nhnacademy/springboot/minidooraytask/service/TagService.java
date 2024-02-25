package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Project;
import com.nhnacademy.springboot.minidooraytask.domain.Tag;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TagName;
import com.nhnacademy.springboot.minidooraytask.exception.ProjectNotFoundException;
import com.nhnacademy.springboot.minidooraytask.repository.ProjectRepository;
import com.nhnacademy.springboot.minidooraytask.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    public List<TagName> getTags(Long projectId) {
        return tagRepository.findAllByProject_ProjectId(projectId);
    }

    public Tag getTag(Long projectId, Long tagId) {
        return tagRepository.findByProject_ProjectIdAndTagId(projectId, tagId);
    }

    public Tag createTag(Long projectId, TagName tagName) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isEmpty()) {
            throw new ProjectNotFoundException(projectId);
        }
        Tag tag = new Tag();
        tag.setProject(optionalProject.get());
        tag.setTagName(tagName.getTagName());
        return tagRepository.save(tag);
    }

    public Tag modifyTag(Long projectId, Long tagId, TagName tagName) {
        Tag tag = tagRepository.findAllByProject_ProjectIdAndTagId(projectId, tagId);
        tag.setTagName(tagName.getTagName());

        return tagRepository.save(tag);
    }

    public void deleteTag(Long projectId, Long tagId) {
        tagRepository.deleteByProject_ProjectIdAndTagId(projectId, tagId);

    }
}
