package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_manager_Id")
    private String projectManagerId;


    @Column(name = "projectStatus")
    private String projectStatus;
}
