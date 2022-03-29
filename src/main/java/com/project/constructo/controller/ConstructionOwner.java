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

import com.project.constructo.model.ConstructOwner;
import com.project.constructo.repository.ConstructoOwnerRepo;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/construction")
public class ConstructionOwner {

	@Autowired
	ConstructoOwnerRepo obj;
	
	//Get All Users
	@GetMapping("/users")
	public List<ConstructOwner> findAll()
	{
		return obj.findAll();
	}
	
	//Adding Contruction owner
	@PostMapping("/add")
	//@PostMapping(value="/add", consumes={"application/json"})
	public ConstructOwner addUser(@RequestBody ConstructOwner owner)
	{
		owner.setVerify_Status("not verified");
		return obj.save(owner);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConstructOwner> getOwnerById(@PathVariable Long id)
	{
		ConstructOwner owner=obj.findById(id).orElseThrow();
		return ResponseEntity.ok(owner);
		
	}
}
