package com.example.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class RequestLogging {

    private static final Logger logger = LoggerFactory.getLogger(RequestLogging.class);


    @Before("@annotation(LogRequestBody)")
    public void logRequest(JoinPoint joinPoint) {
        logger.debug("Logging aspect triggered for method: {}", joinPoint.getSignature().getName());
    }
}