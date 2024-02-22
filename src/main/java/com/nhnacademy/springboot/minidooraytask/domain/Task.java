package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @Column(name = "task_id")
    private Integer taskId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;



    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    private String subject;

    private String contents;
}
