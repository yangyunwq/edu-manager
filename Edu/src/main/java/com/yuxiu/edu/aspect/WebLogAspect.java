package com.yuxiu.edu.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yangyun
 * @date 2019-08-06 09:48
 */
@Aspect
@Component
public class WebLogAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.*.*.controller.*.*(..))")
    public void weblog() {}
}
