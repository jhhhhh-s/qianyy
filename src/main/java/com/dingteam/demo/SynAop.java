package com.dingteam.demo;

import com.rabbitmq.tools.json.JSONUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Arrays;

@Component
@Aspect
public class SynAop {


    @Pointcut("execution(public * com.dingteam.demo.controller.SynDemoController.testAop(..))")
    public void point(){}

    @Before("point()")
    public  void  beforeAop(){
//        System.out.println("前置通知 = " + "前置通知");
    }


    @After("point()")
    public  void  afterAop(){
//        System.out.println("后置通知 = " + "后置通知");
    }

    /*
     在有环绕通知的情况下，如果不执行joinPoint.proceed()这句，前置通知是不会被执行的
     如果没有环绕通知，前置通知会被执行
     */
    @Around("point()")
    public  void  aroundAop(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知执行前----------");

        //获取所有的参数值
        Object [] args = joinPoint.getArgs();
        Arrays.asList(args).stream().forEach(System.out::println);

        //获取所有的参数名称
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Parameter[] paramters = methodSignature.getMethod().getParameters();
        Arrays.asList(paramters).stream().forEach(parameter -> System.out.println("parameter.getName() = " + parameter.getName()));

        
        //获取方法的注解
        Annotation[] annotations = methodSignature.getMethod().getAnnotations();
        Arrays.asList(annotations).stream().forEach(annotation -> System.out.println("annotation = " + annotation));


        //获取方法参数的注解
        Arrays.asList(paramters).stream().forEach(parameter -> System.out.println("isAnnotationPresent = " + parameter.isAnnotationPresent(RequestParam.class)));

        joinPoint.proceed();
        System.out.println("环绕通知执行后----------");

    }


}
