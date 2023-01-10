package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.example.entity.Member;
import com.example.entity.emf.UniqueEntityManagerFactory;

public class MemberService {
	
	public void save(Member member) {
		//EntityManagerFactory : 애플리케이션 당 하나만 공유
		EntityManagerFactory emf = UniqueEntityManagerFactory.emf;	
		
		//엔티티 매니저 : 엔티티 매니저 팩토리를 생성
		EntityManager em = emf.createEntityManager();
		
		//트랜잭션(쪼갤 수 없는 업무의 단위)
		EntityTransaction tx = em.getTransaction();
		
		
		try {
			tx.begin();	//트랜젝션 시작과 동시에 커넥션을 획득
			em.persist(member);		//영속 : 엔티티를 매니저를 통해 엔티티를 속성 컨텍스트에 저장.(비영속 -> 영속)
			tx.commit();		//실제 DB에 저장된다.
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
			//em.detacth(member);
			//em.clear();
			
//			em.remove(member);    
		}
		
		
		
		
	}
}
