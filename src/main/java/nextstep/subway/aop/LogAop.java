package nextstep.subway.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Component
@Aspect
public class LogAop {

    private final Logger log = LoggerFactory.getLogger(LogAop.class);

//    @Around("execution(* nextstep.subway.line.application.LineService.*(..))")
//    @Around("execution(* nextstep.subway.*.*(..))")
//    public void line(ProceedingJoinPoint joinPoint) throws Throwable {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        String methodName = methodSignature.getMethod().getName();
//        String arguments = Arrays.toString(joinPoint.getArgs());
//        log.info("{} | {}", methodName, arguments);
//        joinPoint.proceed();
//
//        stopWatch.stop();
//        log.info("total taken time : {}", stopWatch.getTotalTimeSeconds());
//    }

}
