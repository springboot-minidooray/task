package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.Tag;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TagName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<TagName> findAllByProject_ProjectId(Long projectId);

    Tag findAllByProject_ProjectIdAndTagId(Long projectId, Long tagId);

    void deleteByProject_ProjectIdAndTagId(Long projectId, Long tagId);
}
