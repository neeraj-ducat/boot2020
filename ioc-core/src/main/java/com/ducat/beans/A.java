package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class A {

	@Autowired
	private D d;
	
	@Autowired
	private E e;
	
	public A() {
		System.out.println("A is instantiated.");
	}
	
	@Bean
	public E getE()
	{
		System.out.println("Factory method of E is invoked.");
		return new E();
	}
	public void setD( D d) {
		this.d=d;
		System.out.println("D is injeted into A.");
	}
	public void display()
	{
		System.out.print("It is A bean");
		if(d !=null)
			System.out.println(", it has D bean.");
		else
			System.out.println(".");
	}
}
