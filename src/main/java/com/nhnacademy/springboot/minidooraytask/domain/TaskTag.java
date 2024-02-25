package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
    @AllArgsConstructor
    @Getter
    public static class Pk implements Serializable {
        @ManyToOne
        @JoinColumn(name = "task_id")
        private Task task;

        @ManyToOne
        @JoinColumn(name = "tag_id")
        private Tag tag;

    }
}
