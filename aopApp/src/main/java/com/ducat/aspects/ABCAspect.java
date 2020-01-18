package com.ducat.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	@Before("pc1() || pc3()")
	public void preProcessing(JoinPoint jp)
	{
		String m = jp.getSignature().getName()+"()";
		System.out.println("Before advice is applied on "+m);
	}
	// Throws advice
	@AfterThrowing(value="pc3()",throwing="ex")
	public void errorProcessing(JoinPoint jp, Exception ex)
	{
		String m = jp.getSignature().getName()+"()";
		System.out.println("Throws advice is applied on "
		+m+" because of "+ex);
	}
	
	// After advice
	/*@AfterReturning(value="pc2()",returning="rvalue")
	public void postProcessing(JoinPoint jp, Object rvalue)
	{
		String m = jp.getSignature().getName()+"()";
		System.out.println("After advice is applied on "
		+m+" when "+rvalue+" is returned by it.");
		rvalue="failure";
		System.out.println("Return value is changed to failure by the advice.");
		
	}*/
// Around advice
	@Around(value="pc2()")
	public Object aroundProcessing(ProceedingJoinPoint jp) throws Throwable
	{
		// pre processing
		String m = jp.getSignature().getName()+"()";
		System.out.println("Around advice is applied on "
		+m);
		//return "short circuited";
		//Getting the method invoked on target
		Object rvalue= jp.proceed();
		// post processing
		System.out.println(rvalue+" is returned by "+m);
		rvalue="failure";
		System.out.println("Return value is changed to failure by the advice.");
		return rvalue;
	}	
	
}
