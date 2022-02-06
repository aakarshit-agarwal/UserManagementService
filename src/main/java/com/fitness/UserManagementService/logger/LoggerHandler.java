package com.fitness.UserManagementService.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoggerHandler {

    @Around("execution(public * *(..)) && within(com.fitness.UserManagementService..*)")
    private Object logAroundEveryPublicMethod(ProceedingJoinPoint pjp) throws Throwable {
        final Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
        final Signature methodSignature = pjp.getSignature();
        final List<String> arguments = Arrays.stream(pjp.getArgs()).map(Object::toString).toList();
        logger.info("Calling " + methodSignature + " with arguments " + arguments);

        final Object returnedValue = pjp.proceed();
        logger.info(methodSignature + " returned " + returnedValue);
        return returnedValue;
    }
}
