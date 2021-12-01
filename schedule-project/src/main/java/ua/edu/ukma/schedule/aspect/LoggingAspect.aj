package ua.edu.ukma.schedule.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Log4j2
public class LoggingAspect {


    @Around("@annotation(ua.edu.ukma.schedule.annotation.LogExecutionTime)")
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.error("test aop 1");
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        StopWatch stopWatch = new StopWatch(className + "->" + methodName);
        stopWatch.start(methodName);
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.debug(stopWatch.prettyPrint());
        return result;
    }

    @Around("execution(* *(..)) && @annotation(ua.edu.ukma.schedule.annotation.LogParams)")
    public Object methodParamsLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.error("test aop 2");
        String[] argNames = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        Object[] values = proceedingJoinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }

        log.debug("-> method " + proceedingJoinPoint.getSignature().getName() + " invocation");
        if (!params.isEmpty()){
            log.debug(params);
        }

        Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        log.debug("Result " + result);
        return result;
    }
}