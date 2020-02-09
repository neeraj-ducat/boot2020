package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.dao.EmpDao;
import com.ducat.dao.PersonDao;
import com.ducat.dao.StudentDao;
import com.ducat.entities.Emp;
import com.ducat.entities.Person;
import com.ducat.entities.Student;

@RestController
@RequestMapping("/persons")
public class PersonsController {

	@Autowired
	PersonDao pdao;
	
	@Autowired
	EmpDao edao;
	
	@Autowired
	StudentDao sdao;
	
	//to save a person
	@PostMapping(value="/",consumes="application/json")
	public String savePerson(
			@RequestBody Person p)
	{
		pdao.save(p);
		return "Successfully saved.";
	}
	
	//to save an emp
	@PostMapping(value="/emp",consumes="application/json")
	public String saveEmp(
			@RequestBody Emp e)
	{
		edao.save(e);
		return "Successfully saved.";
	}
	
	//to save a student
	@PostMapping(value="/student",consumes="application/json")
	public String saveStudent(
			@RequestBody Student s)
	{
		sdao.save(s);
		return "Successfully saved.";
	}
	
	//to fetch all persons.
	@GetMapping(value="/",produces="application/json")
	public Iterable<Person> getAll()
	{
		
		return pdao.findAll();
	}
}
