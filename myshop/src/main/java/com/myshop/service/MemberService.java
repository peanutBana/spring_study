package com.myshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Member;
import com.myshop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service					//service 클래스의 역할
@Transactional				//서비스 클래스에서 로직을 처리하다 에러 발생시 수행 이전상태로 되돌려준다. 
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;	//의존성 주입
	
	public Member saveMember(Member member) {
		validateDuplicateMember(member);	//증복체크 후 insert
		return memberRepository.save(member);		//member 테이블에 Insert
	}
	
	//email 중복체크 메소드
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		
	if(findMember != null) {	//이메일이 이미 존재할 때
		throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
}
