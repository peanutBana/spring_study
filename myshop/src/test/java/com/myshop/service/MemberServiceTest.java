package com.myshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import com.myshop.dto.MemberFormDto;
import com.myshop.entity.Member;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Member createMember() {
		MemberFormDto member = new MemberFormDto();
		member.setName("홍길동");
		member.setEmail("test@gmail.com");
		member.setAddress("서울시 마포구 합정동");
		member.setPassword("1234");
		
		return Member.createMember(member, passwordEncoder);
	}
	
	@Test
	@DisplayName("회원가입 테스트")
	public void saveMemberTest() {
		Member member = createMember();
		Member saveMember = memberService.saveMember(member);
		
		assertEquals(member.getEmail(), saveMember.getEmail());
		assertEquals(member.getName(), saveMember.getName());
		assertEquals(member.getAddress(), saveMember.getAddress());
		assertEquals(member.getPassword(), saveMember.getPassword());
		assertEquals(member.getRole(), saveMember.getRole());
	}
	
	@Test
	@DisplayName("중복 회원가입 테스트")
	public void saveDuplicateMemberTest() {
		Member member1 = createMember();
		Member member2 = createMember();
		
		memberService.saveMember(member1);
		
		//예외처리 테스트
		Throwable e = assertThrows(IllegalStateException.class, ()->{
			memberService.saveMember(member2);
		});
		
		assertEquals("이미 가입된 회원입니다.", e.getMessage());
	}

}
