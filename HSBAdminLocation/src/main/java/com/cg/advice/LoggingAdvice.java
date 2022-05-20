package com.cg.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
//Logging class is annotated with Aspect
//and  @Aspect on class to make it AOP aspect. It will have the methods
//which can intercept the methods and apply advice around those methods.
@Aspect
@Component //PointCut are basically those Joinpoints where you can put your advice(or call aspect)
public class LoggingAdvice {

	// The LoggerFactory is a utility class producing Loggers for
	 // various logging APIs, most notably for log4j 
	Logger logger=  LoggerFactory.getLogger(LoggingAdvice.class);
	
	//pointcut will inform toString aop who will be our actual target and where iam going to implement this piece of code i.e our logging mechanism
	@Pointcut(value="execution(* com.cg.*.*.*(..) )") //path for all layer
	public void myPointcut() {
		
	}
	//Around is the pointcut expression where we want to bind the advice
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		//The ProceedingJoinPoint class argument provides us the class name and method name
		//which is going to be executed.
		
		// to convert array or any object into JSON format
		ObjectMapper mapper=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object[] array=pjp.getArgs();
		// this statement will help before advice
		logger.info("method invoked " + className + " : " + methodName + "()" + "argumenmts : " + mapper.writeValueAsString(array));
		Object object=pjp.proceed();
		//capturing response from the server
		logger.info(className + " : " + methodName + "()" + "Response : " + mapper.writeValueAsString(object));
		return object;
	}
}
