package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class B {

	
	private D d;
	
	@Autowired
	public B(D d) {
		this.d =d;
		System.out.println("B is instantiated and D is injected.");
	}
}
