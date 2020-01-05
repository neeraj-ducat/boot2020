package com.ducat.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class D {

	
	public D() {
		System.out.println("D is instantiated.");
	}
}
