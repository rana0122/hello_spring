package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//스프링 컨테이너에 스프링 빈을 등록할 대, 기본으로 싱글톤으로 등록
//유일하게 하나만 등록하여 공유
//같은 스프링 빈이면 같은 인스턴스
@Controller//@Component를 포함하는 애노테이션은 스프링 빈에 자동등록된다.
public class MemberController {
    //여러개의 인스턴스를 생성할 필요가 없기 때문에 spring bean을 사용하도록 한다.
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("MemberService : "+ memberService.getClass()); //proxy호출 되는 부분 확인 가능함.
    }
}
