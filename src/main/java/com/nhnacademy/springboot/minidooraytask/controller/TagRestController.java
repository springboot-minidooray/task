package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.domain.Tag;
import com.nhnacademy.springboot.minidooraytask.domain.dto.TagName;
import com.nhnacademy.springboot.minidooraytask.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tags")
public class TagRestController {
    private final TagService tagService;

    @GetMapping
    public List<TagName> getTags(@PathVariable Long projectId) {
        return tagService.getTags(projectId);
    }

    @PostMapping
    public Tag createTag(@PathVariable Long projectId, @RequestBody TagName tagName) {
        return tagService.createTag(projectId, tagName);
    }

    @PutMapping("/{tagId}")
    public Tag modifyTag(@PathVariable Long projectId, @PathVariable Long tagId, @RequestBody TagName tagModifyDto) {
        return tagService.modifyTag(projectId, tagId, tagModifyDto);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<String> deleteTag(@PathVariable Long projectId, @PathVariable Long tagId) {
        tagService.deleteTag(projectId, tagId);
        return ResponseEntity.ok("deleted tag");
    }
}
