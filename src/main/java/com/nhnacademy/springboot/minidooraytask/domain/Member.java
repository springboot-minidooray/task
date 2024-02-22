package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Member {
    @EmbeddedId
    private Pk pk;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Pk implements Serializable {
        @Column(name = "project_id")
        private Long projectId;

        @Column(name = "member_id")
        private String memberId;
    }

}
