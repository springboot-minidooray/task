package com.nhnacademy.springboot.minidooraytask.repository;

import com.nhnacademy.springboot.minidooraytask.domain.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    Milestone findByProjectIdAndMilestoneId(Long projectId, Long milestoneId);

    void deleteByProjectIdAndMilestoneId(Long projectId, Long milestoneId);
}
