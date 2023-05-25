package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    //생성자 주입
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/join")
    public String joinForm(){
        return "join";
    }

    @GetMapping("/member/login")
    public String login(){
        return "login";
    }

    @PostMapping("/member/join")
    public String join(@ModelAttribute MemberDTO memberDTO){
        System.out.println(memberDTO);
//        memberService.save(memberDTO);
        return null;
    }

}
