package com.myshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.dto.MemberFormDto;
import com.myshop.entity.Member;
import com.myshop.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/members")
@RequiredArgsConstructor
public class MemberController {
   private final MemberService memberService;
   private final PasswordEncoder passwordEncoder;
   
   //회원가입 화면
   //get방식 request
   @GetMapping(value = "/new")
   public String memberForm(Model model) {
      model.addAttribute("memberFormDto", new MemberFormDto());
      return "member/memberForm";
   }
   
   //회원가입 버튼을 눌렀을 때 실행되는 메소드
   //post방식 request
   @PostMapping(value = "/new")
   public String memberForm(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
      //@Valid : 유효성을 검증하려는 객체 앞에 붙인다.
      //BindingResult : 유효성 검증 후에 결과를 넣어준다.
      
      if(bindingResult.hasErrors()) {
         return "member/memberForm";
      }
      
      try {
         Member member = Member.createMember(memberFormDto, passwordEncoder);
          memberService.saveMember(member);
      }catch(IllegalStateException e) {
         model.addAttribute("errorMessage",e.getMessage());
         return "member/memberForm";
      }
      
      return "redirect:/";
   }
   
   //로그인 화면
   @GetMapping(value = "/login")
   public String loginMember() {
      return "member/memberLoginForm";
   }
   
   private final SessionManager sessionManager;
   
//   쿠키, 세션 테스트
//   @PostMapping(value = "/login")
//   public String loginMember2(HttpServletResponse response, HttpSession session, @RequestParam String email) {
//      System.out.println("email: " + email);
//      Cookie idCookie = new Cookie("userCookieId", email);
//      response.addCookie(idCookie);
//      
//      session.setAttribute("userSessionId", email);      //email을 session에 저장
//      sessionManager.createSession("sessionPerson", response);
//      
//      return "member/memberLoginForm";
//   }
   
   //로그인 실패시 
   @GetMapping(value = "/login/error")
   public String loginError(Model model) {
      model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
      return "member/memberLoginForm";
   }
   
   
   
}