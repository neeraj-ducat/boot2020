package com.ducat.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;

@Controller
@RequestMapping("/users")
public class UserController {

	//Dependency of the Controller
	
	@Autowired
	private UserDao dao;
	
	//Method to serve the home page
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home()
	{
		return "index";
	}
	
	//Method to process the registration request
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String add(@ModelAttribute User user)
	{
		dao.save(user);
		return "registered";
	}
	
	//Method to process the login request
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user,
			HttpSession session) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		List<User> list=dao.findByMailId(user.getMailId());
		if(list.isEmpty())
		{
			mav.setViewName("relogin");
		}else if(list.get(0).getPassword().equals(user.getPassword()))
		{
			mav.setViewName("home");
			session.setAttribute("user", list.get(0));
			System.out.println("Settting "+list.get(0).getName()+" in session.");
		}
		else
		{
			mav.setViewName("relogin");
		}
		return mav;
	}
	
}
