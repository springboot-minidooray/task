package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class TaskTag {
    @EmbeddedId
    private Pk pk;

    @Embeddable
    @NoArgsConstructor
    public static class Pk implements Serializable {
        @ManyToOne
        @JoinColumn(name = "task_id")
        private Task task;

        @ManyToOne
        @JoinColumn(name = "tag_id")
        private Tag tag;

    }
}
