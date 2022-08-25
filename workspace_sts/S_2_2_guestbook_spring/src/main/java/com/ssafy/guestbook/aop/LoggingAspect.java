package com.ssafy.guestbook.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    // * - return type, com.ssafy.guestbook.model.. - 패키지로 시작하는 모든 경로에 적용,
    // *.* - 모든 클래스, 모든 메소드, (..) - 메서드의 모든 파라미터 
    // 메소드 첫 라인에 수행된다.
    @Before(value = "execution(* com.ssafy.guestbook.model..*.*(..))")
    public void loggin(JoinPoint jp) {
        // getSignature() - 수행하는 현재 메소드 정보 출력
        logger.debug("메서드 선언부 : {} 전달 파라미터 : {}", jp.getSignature(), Arrays.toString(jp.getArgs()));
    }
    
}
