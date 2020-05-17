package com.nuoya.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Aspect     切面
 * Pointcut   切点   连接点的集合 方法只是一个注解的载体
 * Join Point 连接点  目标对象中的方法
 * advice     通知
 *
 * Weaving    织入
 * https://shimo.im/docs/Nj0bcFUy3SYyYnbI/read
 */
@Aspect
@Component
public class NuoyAspect {

    @Pointcut("execution(* com.nuoya.dao.AclDao.*(..))")
    public void pointCut() {}

    @Pointcut("within(com.nuoya.dao.AclDao)")
    public void pointCut1() {}

    @Pointcut("args(String)")
    public void pointCut2() {}

    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }
    @Before("pointCut1()")
    public void before1(){
        System.out.println("before1");
    }

    @After("pointCut2()")
    public void after1(){
        System.out.println("after2");
    }
    @After("com.nuoya.annotation.NuoyAspect.pointCut()")
    public void after(){
        System.out.println("after");
    }
    @Around("this(com.nuoya.dao.UserDaoImpl)")
    public void arroundDemo(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("demo before");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println(throwable);
            throwable.printStackTrace();
        }
        System.out.println("demo after");
    }
}
