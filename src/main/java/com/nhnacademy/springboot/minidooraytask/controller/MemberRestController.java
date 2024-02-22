package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.domain.Member;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MemberListDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MemberRegisterDto;
import com.nhnacademy.springboot.minidooraytask.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/members")
public class MemberRestController {
    private final MemberService memberService;

    @GetMapping
    public List<MemberListDto> getMembers(@PathVariable Long projectId) {
        List<Member> members = memberService.getMembers(projectId);
        return members.stream().map(member -> new MemberListDto(member.getPk().getProjectId(), member.getPk().getMemberId())).collect(Collectors.toList());
    }

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable Long projectId, @PathVariable String memberId) {
        return memberService.getMember(projectId, memberId);
    }

    @PostMapping
    public Member createMember(@PathVariable Long projectId, @RequestBody MemberRegisterDto memberRegisterDto) {
        return memberService.createMember(projectId, memberRegisterDto);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long projectId, @PathVariable String memberId) {
        try {
            memberService.deleteMember(projectId, memberId);
            return ResponseEntity.ok("member deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error deleting member");
        }
    }
}
