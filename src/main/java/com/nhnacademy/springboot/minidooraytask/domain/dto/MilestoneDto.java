package com.nhnacademy.springboot.minidooraytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MilestoneDto {
    private String milestone;
    private LocalDate startDate;
    private LocalDate endDate;
}
