package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository //@Component를 포함하는 애노테이션은 스프링 빈에 자동등록된다.
public class MemoryMemberRespository implements MemberRepository{

    //Member table대신 사용할 메모리 변수 Member 저장을 위해 seq,Member객체로 저장하여 사용한다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence=0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional.ofNullable을 사용하면 반환값이 null이여도 처리가 가능하다.
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
                .filter(member -> member.getName().equals(name))
               .findAny(); // loop를 돌면서 하나라도 찾으면 바로 반환, 없으면  Optional반환
    }

    @Override
    public List<Member> findAll() {
        //store.values() : 모든 값 (Member 객체들)을 Collection 형태로 가져옴.
        //store의 모든 값들을 리스트로 변환하여 새로운 ArrayList로 반환.
        //결론적으로  Member들의 list 반환이 가능함.
        return new ArrayList<>(store.values());

    }

    public void clearStore(){
        store.clear();
    }
}
