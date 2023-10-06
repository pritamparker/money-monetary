package com.natwest.transactionapi.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Before(value = "execution(* com.natwest.transactionapi.controller.TransactionController.addTransaction(..))")
	public void logForBeforeExecutionAddTransaction(JoinPoint joinPoint) {
		log.info("********************************************");
		log.info("Method: " + joinPoint.getSignature().getName());
		log.info("Declarative name: " + joinPoint.getSignature().getDeclaringTypeName());
		log.info("Method Arguments: " + Arrays.toString(joinPoint.getArgs()));
		
		log.info("This is before log created");
		log.info("********************************************");
	}
	
	@After(value = "execution(* com.natwest.transactionapi.controller.TransactionController.addTransaction(..))")
	public void logForAfterExecutionAddTransaction(JoinPoint joinPoint)  {
		log.info("********************************************");
		log.info("Method: " + joinPoint.getSignature().getName());
		log.info("Method Arguments: " + Arrays.toString(joinPoint.getArgs()));
		log.info("This is after log created");
		log.info("********************************************");
	}
	
	@Around(value = "execution(* com.natwest.transactionapi.controller.TransactionController.addTransaction(..))")
	public Object logAroundEntireApplication(ProceedingJoinPoint joinPoint) throws Throwable {
		
		log.info("Method name: " + joinPoint.getSignature().getDeclaringTypeName());
		log.info("Method arguments:" +joinPoint.getArgs());
		log.info("**************Around advice called***********************");
		
		//we use the object to store the output using the proceed() method
		Object obj;
		try {
			obj= joinPoint.proceed();
			
			log.info("Output:" +obj);
		
		return obj;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	
	

}
