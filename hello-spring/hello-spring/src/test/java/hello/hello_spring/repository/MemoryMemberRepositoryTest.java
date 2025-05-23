package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //테스트는 순차적으로 진행되지 않는데 그렇기 때문에 각 테스트가 끝나면 store 을 지워주도록 한다.
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring1");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(result,member);
        //Assertions.assertThat(member).isEqualTo(result); //core.api 라이브러리에 있는건데 이게 더 편하다고 함
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result1 = repository.finalByName("spring1").get();
        Member result2 = repository.finalByName("spring2").get();

        assertThat(result1).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
