package com.nhnacademy.springboot.minidooraytask.service;

import com.nhnacademy.springboot.minidooraytask.domain.Member;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MemberListDto;
import com.nhnacademy.springboot.minidooraytask.domain.dto.MemberRegisterDto;
import com.nhnacademy.springboot.minidooraytask.exception.MemberAlreadyExistException;
import com.nhnacademy.springboot.minidooraytask.exception.MemberNotFoundException;
import com.nhnacademy.springboot.minidooraytask.repository.MemberRepository;
import com.nhnacademy.springboot.minidooraytask.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    public List<Member> getMembers(Long projectId) {
        return memberRepository.findAllByProject_projectId(projectId);
    }

    public Member getMember(Long projectId, String memberId) {
        Member.Pk pk = new Member.Pk(projectId, memberId);
        Optional<Member> member = memberRepository.findById(pk);
        if (member.isPresent()) {
            return member.get();
        } else {
            throw new MemberNotFoundException(projectId, memberId);
        }
    }

    public Member createMember(Long projectId, MemberRegisterDto memberRegisterDto) {
        Member.Pk pk = new Member.Pk(projectId, memberRegisterDto.getMemberId());
        if(memberRepository.existsById(pk)) {
            throw new MemberAlreadyExistException(projectId, memberRegisterDto.getMemberId());
        }

        Member member = new Member();
        member.setPk(pk);
        member.setProject(projectRepository.findById(projectId).get());

        return memberRepository.save(member);
    }

    public void deleteMember(Long projectId, String memberId) {
        Member.Pk pk = new Member.Pk(projectId, memberId);
        if (memberRepository.existsById(pk)) {
            memberRepository.deleteById(pk);
        } else {
            throw new MemberNotFoundException(projectId, memberId);
        }
    }
}
