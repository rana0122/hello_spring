package hello.hello_spring.service;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//   private DataSource dataSource; //jdbc, template
//   private EntityManager em; //JPA
    //spring Data JPA가 만들어놓은 구현체를 자동으로 injection 해줌.
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired
//    public SpringConfig(DataSource dataSource) { //jdbc, template
//        this.dataSource = dataSource;
//    }
//   @Autowired
//    public SpringConfig(EntityManager em) { //JPA
//        this.em = em;
//    }

    @Bean // DI 생성자를 통해서 의존성 주입을 한다. 의존관계가 동적으로 변하는 경우가 아닌 이상,필드주입, 세터주입도 있는데 사용하지 말자
    public MemberService memberService(){
//        return  new MemberService(memberRepository());
        return  new MemberService(memberRepository);
    }
//    @Bean
//    @Lazy
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository  memberRepository(){ //MemberRepository는 interface이므로 구현체를 반환한다.
//        return  new MemoryMemberRespository();
//        return  new JdbcMemberRepository(dataSource); //JDBC
//        return new JdbcTemplateMemberRepository(dataSource);  //JBDCTemplate
//        return new JpaMemberRepository(em); //JPA
//
//
//    }

}
