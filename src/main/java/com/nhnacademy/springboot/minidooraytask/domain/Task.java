package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "task_manager_id")
    private String taskManagerId;

    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    private String subject;

    private String contents;

    private String status;
}
