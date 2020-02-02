package com.ducat.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.dao.EmpDao;
import com.ducat.entities.Emp;

@RestController
@RequestMapping("/employees")
public class EmpController {

	@Autowired
	private EmpDao dao;
	
	
	//To save an Emp
	@PostMapping(value="/",consumes="application/json",
			produces="text/plain")
	public String save(@RequestBody Emp e) {
		dao.save(e);
		return "successfully saved.";
	}
	
	//To update an Emp
	@PutMapping(value="/",consumes="application/json",
			produces="text/plain")
	public String update(@RequestBody Emp e) {
		dao.update(e);
		return "successfully updated.";
	}
	
	//To remove an Emp
	@DeleteMapping(value="/{id}",
			produces="text/plain")
	public String update(@PathVariable int id) {
		dao.remove(id);
		return "successfully removed.";
	}
	
	//To fetch all Employees
	@GetMapping(value="/",
			produces="application/json")
	public List<Emp> getAll() throws Exception {
	   return	dao.allEmp();
		
	}
	
	//To fetch an Emp using Id
	@GetMapping(value="/{id}",
			produces="application/json")
	public Emp getById(@PathVariable int id) throws Exception {
	   return	dao.empById(id);
		
	}
}
