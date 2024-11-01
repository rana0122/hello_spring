package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRespository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

//    MemberService memberService = new MemberService();
//    MemoryMemberRespository memberRepository = new MemoryMemberRespository();

    MemberService memberService;
    MemoryMemberRespository memberRepository;

    @BeforeEach
    void beforeEach() { //MemberService에서 MemoryMemberRespository에 대한 의존성 분리하도록 수정한 부분에 대한 Test에서의 의존성 주입
        memberRepository= new MemoryMemberRespository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();;
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("test");
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



    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}