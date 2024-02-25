package com.nhnacademy.springboot.minidooraytask.domain.dto;

import com.nhnacademy.springboot.minidooraytask.domain.Tag;

public interface TaskDto {
    String getSubject();
    String getStatus();
    MilestoneName getMilestone();
    TaskTagList getTags();
    CommentList getComments();

    interface MilestoneName {
        String getMilestoneName();
    }

    interface TaskTagList {
        Tag getTag();

        interface TagName {
            String getTagName();
        }
    }

    interface CommentList {
        Integer getCommentId();
        String getWriterId();
        String getContents();
    }

}
