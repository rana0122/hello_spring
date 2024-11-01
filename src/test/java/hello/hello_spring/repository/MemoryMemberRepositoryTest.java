package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//test는 다른데서 가져다 쓸 게 아니기 때문에 public  필요없음.
class MemoryMemberRepositoryTest {
    MemoryMemberRespository repository = new MemoryMemberRespository();

    @AfterEach //@Test 메소드가 끝날때마다 동작하는 메소드
    public  void  afterEach(){
        repository.clearStore();
    }

    @Test
    public  void save(){
        //new member 저장
        Member member = new Member();
        member.setName("hellospring");
        repository.save(member);

        //new member가 제대로 저장됐는지 확인.
        Member result =repository.findById(member.getId()).get();
        System.out.println("result= " + (result == member));
        assertThat(member).isEqualTo(result); //static method import alt+enter.
    }

    @Test
    public  void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public  void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> members = repository.findAll();
        assertThat(members.size()).isEqualTo(2);
    }
}
