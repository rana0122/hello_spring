package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRespository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional // Test케이스에 이 애노테이션이 있으면, TEST한 데이타는 rollback함. @AferEach와  @BeforeEach 필요없어짐.
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test
    @Commit
    void join() {
        //given
        Member member = new Member();
        member.setName("test100");
        //when
        Long id = memberService.join(member);
        //then
        Member findmember = memberService.findOne(id).get();
        assertThat(member.getName()).isEqualTo(findmember.getName()); //static method import :alt+enter
    }
    @Test
    void ExceptionJoin(){
        //given
        Member member1 = new Member();
        member1.setName("test");

        Member member2 = new Member();
        member2.setName("test");
        //when : 이름이 중복된 회원이 가입하기 때문에 예외 발생 코드로 넘어감.
        // validateDuplicateMember(member);
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("duplicate member");


//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("duplicate member");
//
//        }
        //then
    }


}