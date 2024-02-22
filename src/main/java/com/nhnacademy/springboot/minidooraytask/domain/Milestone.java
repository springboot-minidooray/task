package com.nhnacademy.springboot.minidooraytask.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Milestone {
    @Id
    @Column(name = "milestone_id")
    private Long milestoneId;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "milestone_name")
    private String milestoneName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asian/Seoul")
    @Column(name = "start_date")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asian/Seoul")
    @Column(name = "end_date")
    private LocalDate endDate;

}
