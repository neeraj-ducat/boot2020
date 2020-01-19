package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adder")
public class Adder {

	//Method to serve the home page
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home()
	{
		return "index";
	}
	
	//Method to process the add request
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(
		@RequestParam("num1")	int a, 
		@RequestParam("num2") int b)
	{
		System.out.println("add() method is invoked.");
		int c=a+b;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		mav.addObject("sum", c);
		return mav;
	}
	
}
