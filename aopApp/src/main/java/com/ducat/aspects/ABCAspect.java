package com.ducat.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ABCAspect {

	// pointcut to select method a() of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.a(..))")
	public void pc1() {}
	
	// pointcut to select method b() of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.b(..))")
	public void pc2() {}
	
	// pointcut to select method c() of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.c(..))")
	public void pc3() {}
	
	// Before advice
	@Before("pc1() || pc2() || pc3()")
	public void preProcessing()
	{
		System.out.println("Before advice is applied.");
	}
}
