package jpabook;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext //entity manager 주입
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();  //id 정도만 조회
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

}
