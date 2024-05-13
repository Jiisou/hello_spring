package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {
    MemberService memberService = new MemberService();

    //프로덕션 실제 동작하는 코드는 관례상 애매하지만
    //테스트 코드에선 과감하게.. 한글로 작성해도 됩니다! 외국인들이랑 일하는게 아니라면 직관적일이니까, 빌드 될 때 실제 코드에 포함되지도x
    @Test
    void 회원가입() { //join()
        //given "뭔가 어떤 상황이 주어졌는데" = '이 데이터를 기반으로 하는구나'
        Member member = new Member();
        member.setName("hello");

        //when "이걸 실행했을 때" = '이걸 검증하는구나'
        Long saveId = memberService.join(member);

        //then "이런 결과가 나와야 돼" = '여기가 검증부구나'
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1234123");
        }

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}