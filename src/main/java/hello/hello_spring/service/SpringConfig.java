package hello.hello_spring.service;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class SpringConfig {

    @Bean // DI 생성자를 통해서 의존성 주입을 한다. 의존관계가 동적으로 변하는 경우가 아닌 이상,필드주입, 세터주입도 있는데 사용하지 말자
    public MemberService memberService(){
        return  new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){ //MemberRepository는 interface이므로 구현체를 반환한다.
        return  new MemoryMemberRespository();
    }

}
