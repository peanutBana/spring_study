package com.example.service;

import javax.persistence.EntityManagerFactory;

import com.example.entity.Member;
import com.example.entity.emf.UniqueEntityManagerFactory;

public class MemberService {
	
	public void save(Member member) {
		//EntityManagerFactory : 애플리케이션 당 하나
		EntityManagerFactory emf = UniqueEntityManagerFactory.emf;	
		
	}
}
