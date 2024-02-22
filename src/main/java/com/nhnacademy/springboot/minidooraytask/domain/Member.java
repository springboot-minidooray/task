package com.nhnacademy.springboot.minidooraytask.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class Member {
    @EmbeddedId
    private Pk pk;

    @Embeddable
    @NoArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "member_id")
        private String memberId;

        @Column(name = "project_id")
        private Long projectId;
    }

}
