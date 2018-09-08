package com.ahea.nurikabe.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    
    // HTTP post get put delete
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public Integer createMember(Member member) {
        return this.memberService.createMember(member);
    }
    
    @PostMapping("/join")
    public void join(Member member) {
    	this.memberService.join(member);
    }
    
    @PostMapping("/login")
    public void login(Member member) {
    	this.memberService.login(member);
    }
}
