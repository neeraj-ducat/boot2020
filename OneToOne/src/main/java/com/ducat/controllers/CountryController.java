package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.dao.CountryDao;
import com.ducat.entities.Country;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryDao dao;
	
	@PostMapping(value="/", consumes="application/json")
	public String save(@RequestBody Country country)
	{
		dao.save(country);
		return "successfully saved.";
		
	}
	
	
	@GetMapping(value="/", produces="application/json")
	public Iterable<Country> getAll()
	{
		
		return dao.findAll();
		
	}
}
