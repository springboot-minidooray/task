package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.Milestone;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MilestoneName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    List<Milestone> findAllByProjectId(Long projectId);

    Milestone findByProjectIdAndMilestoneId(Long projectId, Long milestoneId);

    void deleteByProjectIdAndMilestoneId(Long projectId, Long milestoneId);

    MilestoneName findByMilestoneId(Long milestoneId);
}
