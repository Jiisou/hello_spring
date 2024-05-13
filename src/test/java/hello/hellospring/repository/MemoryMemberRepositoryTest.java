package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    // MemberRepository repository = new MemoryMemberRepository();
    MemoryMemberRepository repository = new MemoryMemberRepository(); //인터페이스가 아니라 클래스를 테스트 할 것이므로(?)

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("jisu");

        repository.save(member); // 저장소에 멤버를 save

        Member result = repository.findById(member.getId()).get(); // 반환 타입이 옵셔널이었음=> 여기서 값을 꺼낼 때는 get()을 쓸 수 있음.

        // 검증 어떻게? new에서 저장한 거랑 db에서 꺼낸 거랑 똑같으면 참일 것 (?) => 출력해서 확인
        // System.out.println("result = " + (result == member));

        // Assertions.assertEquals(result, member); "expected와 actual의 위치에 대해서 헷갈릴 때가 많다."
        // Assertions.assertEquals(null, member); //기대와 실제가 다르면 assertionfail 에러 발생
        assertThat(member).isEqualTo(result); // "actual이 expected와 같다" 의미 전달이 더 잘된다
    }
    
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring-jisu");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring-hyeoksu");
        repository.save(member2);

        //Optional<Member> result = repository.findByName("spring-jisu");
        //Member result = repository.findByName("spring-hyeoksu").get(); // .get()을 붙이면 Optonal을 떼어서 작성할 수 있다
        Member result = repository.findByName("spring-jisu").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring-jisu");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring-hyeoksu");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
