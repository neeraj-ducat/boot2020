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
		System.out.println("Requesting Conductor Bean...");
		//Conductor con=(Conductor)ctx.getBean("dishonestConductor");
		//Conductor con=(Conductor)ctx.getBean("honestConductor");
		Conductor con=(Conductor)ctx.getBean("conductor");
		System.out.println("Conductor object class is "+con.getClass().getName());
		System.out.println("Requesting two tickets from the conductor...");
		Ticket t1=con.getTicket();
		Ticket t2=con.getTicket();
		System.out.println("Description of tickets:");
		System.out.println(t1);
		System.out.println(t2);
	}

}
