package com.project.constructo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.constructo.dao.LocalDao;
import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.FlatOwner;
import com.project.constructo.model.VisitBook;
import com.project.constructo.repository.VisitBookRepo;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/visitbook")
public class VisitBookController {

	@Autowired
	VisitBookRepo visitrepo;
	
	@Autowired
	LocalDao dao;
	
	
	
	@GetMapping("/users")
	public List<VisitBook> findAll()
	{
		return visitrepo.findAll();
	}
	
	//Adding Contruction owner
	@PostMapping("/add")
	//@PostMapping(value="/add", consumes={"application/json"})
	public VisitBook addvisit(@RequestBody VisitBook owner)
	{
		
		//System.out.println();
		return visitrepo.save(owner);
		
	}
	
	@GetMapping("/{cid}")
	public List<VisitBook> getFlatOwnerByConstructId(@PathVariable Long cid)
	{
		List<VisitBook> owner=dao.getVisitsByConstructId(cid);
		return owner;
		
	}
	
	
	
	
}
