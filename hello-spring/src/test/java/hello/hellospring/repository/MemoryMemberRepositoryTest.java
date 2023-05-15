package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member res = repository.findById(member.getId()).get();
//        System.out.println("result = " + (res == member));
//        Assertions.assertEquals(member, null);
        Assertions.assertThat(member).isEqualTo(res);
    }

}
