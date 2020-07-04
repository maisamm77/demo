package com.example.demo.aspect;

import com.example.demo.annotation.ReturnStringInstead;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Component
@Aspect
public class DemoAspect {

	//("execution(* com.example.demo.controller.DemoController.sayHello(..))")
	public String aroundAspect(ProceedingJoinPoint joinPoint) {
		try {
			joinPoint.proceed();
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		} finally {
			//Do Something useful, If you have
		}
		return "Hello Aspect";
	}

	@Around("@annotation(com.example.demo.annotation.ReturnStringInstead)")
	public String aroundAspectAnnotation(ProceedingJoinPoint joinPoint) {
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		Annotation annotation = method.getAnnotation(ReturnStringInstead.class);

		if(annotation instanceof ReturnStringInstead) {
			ReturnStringInstead myAnnotation = (ReturnStringInstead) annotation;
			return "name: " + myAnnotation.name();
		}

		return "Hello";
	}
}
