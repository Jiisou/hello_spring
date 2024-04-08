package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2,.. key값 생성해줌.

    @Override

    public Member save(Member member) {
        member.setId(++sequence); //store에 넣기 전, member에 id값을 세팅
        store.put(member.getId(), member); //store에 저장하면 맵에 저장됨.
        return member;  //저장된 결과를 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // 이 결과가 없으면? null, =>이렇게 null가능성이 있을때 옵셔널~로 감싸줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // member parameter로 넘어온 name이랑 같은지 확인
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store의 values가 바로 Member들
    }

}
