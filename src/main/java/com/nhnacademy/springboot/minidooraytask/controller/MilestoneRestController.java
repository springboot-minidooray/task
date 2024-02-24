package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.domain.Milestone;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MilestoneDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MilestoneListDto;
import com.nhnacademy.springboot.minidooraytask.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/milestones")
public class MilestoneRestController {
    private final MilestoneService milestoneService;

    @GetMapping
    public List<MilestoneListDto> getMilestones(@PathVariable Long projectId) {
        List<Milestone> milestones = milestoneService.getMilestones(projectId);
        return milestones.stream().map(milestone -> new MilestoneListDto(
                milestone.getMilestoneId(),
                milestone.getMilestoneName(),
                milestone.getStartDate(),
                milestone.getEndDate()
                )).collect(Collectors.toList());
    }

    @GetMapping("/{milestoneId}")
    public MilestoneDto getMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId) {
        Milestone milestone = milestoneService.getMilestone(projectId, milestoneId);
        return new MilestoneDto(
                milestone.getMilestoneName(),
                milestone.getStartDate(),
                milestone.getEndDate()
        );
    }

    @PostMapping
    public Milestone createMilestone(@PathVariable Long projectId, @RequestBody MilestoneDto milestoneDto) {
        return milestoneService.createMilestone(projectId, milestoneDto);
    }

    @PutMapping("/{milestoneId}")
    public MilestoneDto modifyMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId, @RequestBody MilestoneDto milestoneDto) {
        return milestoneService.modifyMilestone(projectId, milestoneId, milestoneDto);
    }

    @DeleteMapping("/{milestoneId}")
    private ResponseEntity<String> deleteMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId) {

        try {
            milestoneService.deleteMilestone(projectId, milestoneId);
            return ResponseEntity.ok("milestone deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error deleting milestone");
        }
    }
}

