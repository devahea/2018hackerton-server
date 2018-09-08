package com.ahea.nurikabe.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long createMember(Member member) {
        Member savedMember = this.memberRepository.save(member);

        return savedMember.getId();
    }
}
