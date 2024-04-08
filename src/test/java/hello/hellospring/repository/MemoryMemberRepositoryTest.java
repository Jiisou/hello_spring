package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("jisu");

        repository.save(member); // 저장소에 멤버를 save

        Member result = repository.findById(member.getId()).get(); // 반환 타입이 옵셔널이었음=> 여기서 값을 꺼낼 때는 get()을 쓸 수 있음.
        // 검증 어떻게? new에서 저장한 거랑 db에서 꺼낸 거랑 똑같으면 참일 것 (?) => 출력해서 확인
        System.out.println("result = " + (result == member));
    }
}
