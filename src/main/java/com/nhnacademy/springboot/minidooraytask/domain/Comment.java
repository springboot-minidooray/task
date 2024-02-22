package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Comment {
    @Id
    @Column(name = "command_id")
    private Integer commandId;

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "member_id")
    private Long memberId;

    private String contents;
}
