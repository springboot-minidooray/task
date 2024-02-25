package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tag {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "tag_name")
    private String tagName;
}
