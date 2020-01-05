package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.*;

@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =
				SpringApplication.run(
				SimpleApplication.class, args);
		System.out.println("Requesting Bean A...");
		A a=(A)ctx.getBean("a");
		a.display();
		System.out.println("Requesting Bean B...");
		B b=(B)ctx.getBean("b");
		System.out.println("Requesting Bean C...");
		C c=(C)ctx.getBean("c");
	}

}
