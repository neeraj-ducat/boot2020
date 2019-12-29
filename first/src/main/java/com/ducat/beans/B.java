package com.ducat.beans;

import org.springframework.stereotype.Component;

@Component
public class B {

	public B() {
		super();
		System.out.println("B is instantiated.");
	}

	public String toString()
	{
		return "B bean.";
	}
	
}
