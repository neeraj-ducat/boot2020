package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.ABC;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx =
				SpringApplication.run(Application.class, args);
		System.out.println("Requesting target object from IOC container...");
		ABC target=(ABC)ctx.getBean(ABC.class);
		System.out.println("Invoking a() of target...");
		target.a();
		System.out.println("Invoking b() of target...");
		String result=target.b();
		System.out.println(result+" is returned by b() in main().");
		System.out.println("Invoking c() of target...");
		try {
			target.c(-5);
		}catch(Exception e)
		{
			System.out.println("Following exception is caught in main(): "+e);
		}

	}

}
