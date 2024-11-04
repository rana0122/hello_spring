package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//Test 파일 만들고 싶으면 ctrl+shift+T
//@Service//@Component를 포함하는 애노테이션은 스프링 빈에 자동등록된다.
@Transactional // JPA 사용하려면 반드시 사용해야함.
public class MemberService {
    //이렇게 Test와 클래스에서 각자 생성하면 다른 객체를 사용하기 때문에 생성자를 이용해서 하나의 객체만 사용하도록 변경한다.
    //의존성을 분리시킴:DI(Dependency Injection) 분리
//    private  final MemberRepository memberRepository = new MemoryMemberRespository();
    private  final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원은 가입할 수 없다.

//        Optional<Member> duplicate = memberRepository.findByName(member.getName());
//        duplicate.ifPresent(m ->{
//            throw  new IllegalStateException("duplicate member");
//        });
        validateDuplicateMember(member); // extract method : ctrl+ alt+M
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw  new IllegalStateException("duplicate member");
                });
    }
    //전체 회원조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }
}
