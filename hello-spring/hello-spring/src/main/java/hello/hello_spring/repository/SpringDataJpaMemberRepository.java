package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    //이게 스프링쪽에 이미 sql 로 있어서 가능함.
    //지금까지 findByName 을 finalByName 으로 써놨었는데(몰랐음 자동완성으로 써서) 그래서 함수명이 뭔 상관이겠어 하고 실행시켰는데 안됨ㅋㅋ
    //신기방기..
    //결론 : JPA Spring Data 쓸때는 함수명 보고 쓸것.

}
