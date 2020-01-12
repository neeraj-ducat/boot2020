package com.ducat.beans;

import org.springframework.stereotype.Component;

@Component
public class ABCImpl implements ABC {

	public void a() {
		System.out.println("a() of target is invoked.");

	}

	public String b() {
		System.out.println("b() of target is invoked, returning success...");
		return "success";
	}

	public void c(int x) throws Exception {
		System.out.print("c() of target is invoked, ");
		if(x < 0)
		{
			System.out.println("throwing exception.");
			throw(new Exception("Input must be > 0"));
		}
		else
		{
			System.out.println("returning normally.");
		}
		
	}

}
