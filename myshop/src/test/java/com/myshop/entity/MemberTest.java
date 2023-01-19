package com.myshop.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;

import com.myshop.repository.MemberRepository;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class MemberTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@PersistenceContext
	EntityManager em;

	@Test
	@DisplayName("Auditing 테스트")
	@WithMockUser(username="gildong", roles = "USER")
	void auditingTest() {
		Member newMember = new Member();
		memberRepository.save(newMember);
		
		em.flush();
		em.clear();
		
		Member member = memberRepository.findById(newMember.getId())
									    .orElseThrow(EntityNotFoundException::new);
		
		System.out.println("등록시간 : " + member.getRegTime());
		System.out.println("수정시간 : " + member.getUpDateTime());
		System.out.println("등록한 사람 : " + member.getCreatedBy());
		System.out.println("수정한 사람 : " + member.getModifiedBy());
	}

}
