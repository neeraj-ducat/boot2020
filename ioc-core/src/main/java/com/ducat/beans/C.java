package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class C {

	
	private D d;
	
	
	public C() {
		System.out.println("C is instantiated.");
	}
	@Autowired
	public void setD( D d) {
		this.d=d;
		System.out.println("D is injeted into C.");
	}
}
