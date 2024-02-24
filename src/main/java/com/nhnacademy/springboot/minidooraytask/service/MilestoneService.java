package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Milestone;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MilestoneDto;
import com.nhnacademy.springboot.minidooraytask.repository.MilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneService {
    private final MilestoneRepository milestoneRepository;
    public List<Milestone> getMilestones(Long projectId) {
        return milestoneRepository.findAllById(Collections.singleton(projectId));
    }

    public Milestone getMilestone(Long projectId, Long milestoneId) {
        return milestoneRepository.findByProjectIdAndMilestoneId(projectId, milestoneId);
    }

    public Milestone createMilestone(Long projectId, MilestoneDto milestoneDto) {
        Milestone milestone = new Milestone();
        milestone.setProjectId(projectId);
        milestone.setMilestoneName(milestoneDto.getMilestone());
        milestone.setStartDate(milestoneDto.getStartDate());
        milestone.setEndDate(milestoneDto.getEndDate());
        return milestoneRepository.save(milestone);
    }

    public MilestoneDto modifyMilestone(Long projectId, Long milestoneId, MilestoneDto milestoneDto) {
        Milestone milestone = milestoneRepository.findByProjectIdAndMilestoneId(projectId, milestoneId);
        if (!milestoneDto.getMilestone().isEmpty()) {
            milestone.setMilestoneName(milestoneDto.getMilestone());
        }
        if (milestoneDto.getStartDate() != null) {
            milestone.setStartDate(milestoneDto.getStartDate());
        }
        if (milestoneDto.getEndDate() != null) {
            milestone.setEndDate(milestoneDto.getEndDate());
        }

        Milestone responeseMilestone = milestoneRepository.save(milestone);
        return new MilestoneDto(responeseMilestone.getMilestoneName(), responeseMilestone.getStartDate(), responeseMilestone.getEndDate());
    }

    public void deleteMilestone(Long projectId, Long milestoneId) {
        milestoneRepository.deleteByProjectIdAndMilestoneId(projectId, milestoneId);
    }
}
