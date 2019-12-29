package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.A;

@SpringBootApplication
public class Application {

	
	
	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(Application.class, args);
		A a=(A)ctx.getBean("a");
		System.out.println(a);
	}

}
