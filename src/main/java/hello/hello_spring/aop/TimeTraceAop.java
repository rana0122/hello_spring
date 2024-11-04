package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // AppConfig 파일에 Bean으로 등록하면 순환참조된다고 서버가 뜨지 않음...
public class TimeTraceAop {

    //적용할 범주를 지정해줌, 프로젝트 하위  service만 적용함.
    //aop에서 시간측정을 위해 proxy를 사용하여 가짜  memberservice 를 띄우고, 실제 메소드를 호출할때 진자  memberservice를 호출함.
    @Around("execution(* hello.hello_spring.service..*(..))")
    public  Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start =System.currentTimeMillis();
        System.out.println("start= " + joinPoint.toString());
        try {
            return joinPoint.proceed(); //ctrl+alt+N 인라인으로 변겯

        }finally {
            long finish =System.currentTimeMillis();
            long timeMS= finish-start;
            System.out.println("End = " + joinPoint.toString()+ " "+timeMS);
            
        }

    }
}
