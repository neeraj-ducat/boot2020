package com.ducat.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;
import com.ducat.validators.MailValidator;

@Controller
@RequestMapping("/users")
public class UserController {

	//Dependency of the Controller
	
	@Autowired
	private UserDao dao;
	@Autowired
	private MailValidator mailValidator;
	
	//Method to serve the home page
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView mav = new ModelAndView();
		//To render the registration page for the first time.
		mav.addObject("user", new User());
		mav.setViewName("index");
		return mav;
	}
	
	//Method to process the registration request
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView register(
		@Valid	@ModelAttribute User user,
		BindingResult validationResult)
	{
		ModelAndView mav = new ModelAndView();
		//custom validation is applied
		mailValidator.validate(user, validationResult);
		if(validationResult.hasErrors())
		{
			mav.setViewName("register"); // to generate the registration form again.
			mav.addObject("user", user);
		}
		else
		{	
		dao.save(user);
		mav.setViewName("registered"); 
		}
		return mav;
	}
	
	//Method to process the login request
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		List<User> list=dao.findByMailId(user.getMailId());
		if(list.isEmpty())
		{
			mav.setViewName("relogin");
		}else if(list.get(0).getPassword().equals(user.getPassword()))
		{
			mav.setViewName("home");
			mav.addObject("user", list.get(0));
		}
		else
		{
			mav.setViewName("relogin");
		}
		return mav;
	}
	
}
