package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//이걸 써야 AOP 파일이 된다.
@Component//이렇게 쓰거나 Config 에서 Bean에 등록해준다. Bean 에 등록하는게 더 알기쉬워서 많이 쓰는 방법
public class TimeTraceAop {

    @Around("execution(* hello.hello_spring..*(..))")//어디에 쓸것인가 타케팅해주는것.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("Start: "+ joinPoint.toString());
        try{
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("TIME: "+ joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
