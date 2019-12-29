package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

	@Autowired
	private B b;
	
	public A() {
		super();
		System.out.println("A is instantiated.");
	}

	public String toString() {
		return "It is A bean, it has "+b;
		
	}
	
}
