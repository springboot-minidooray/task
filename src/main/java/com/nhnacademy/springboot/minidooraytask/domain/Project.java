package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "admin_id")
    private Long project_manager_Id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "projectStatus")
    private String projectStatus;
}
