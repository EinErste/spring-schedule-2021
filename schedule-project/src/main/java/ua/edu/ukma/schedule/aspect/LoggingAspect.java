package ua.edu.ukma.schedule.aspect;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ua.edu.ukma.schedule.exception.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Log4j2
public class LoggingAspect {

    @Around("@annotation(ua.edu.ukma.schedule.annotation.LogExecutionTime)")
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        log.info("Class `{}`, method `{}` invocation ",className,methodSignature);

        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        long executionTime = System.currentTimeMillis() - start;
        log.info("Executed in {} ms", executionTime);
        return proceed;
    }

    @Around("@annotation(ua.edu.ukma.schedule.annotation.LogParams)")
    public Object methodParamsLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        log.info("Class `{}`, method `{}` invocation ",className,methodSignature);


        String[] argNames = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        Object[] values = proceedingJoinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }
        log.info("Params {}", params.isEmpty()? "none": params);


        Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        log.info("Result {}",result);
        return result;
    }
}