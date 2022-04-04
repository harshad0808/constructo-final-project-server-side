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
import com.project.constructo.model.FlatCount;
import com.project.constructo.repository.ConstructoOwnerRepo;
import com.project.constructo.repository.FlatCountRepo;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/construction")
public class ConstructionOwner {

	@Autowired
	ConstructoOwnerRepo obj; //change the name
	
	
	@Autowired
	LocalDao dao;
	
	@Autowired
	FlatCount count;
	
	@Autowired
	FlatCountRepo flatcountrepo;
	
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
		obj.save(owner);
		ConstructOwner returnobj= dao.getConstructOwnerByUsername(owner.getUsrName());
		 String s1 = Long.toString(returnobj.getC_id());
		 String s2=s1+"000";
		 int c = Integer.parseInt(s2);
		count.setCount(c);
		 
		count.setOwner(returnobj);
		flatcountrepo.save(count);
		return obj.save(owner);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConstructOwner> getOwnerById(@PathVariable Long id)
	{
		ConstructOwner owner=obj.findById(id).orElseThrow();
		return ResponseEntity.ok(owner);
		
	}
	
	@PostMapping("/logincons")
	public ResponseEntity<ConstructOwner> checkLogin(@RequestBody ConstructOwner owner)
	{
		String username=owner.getUsrName();
		String password=owner.getC_Password();
		ConstructOwner owner1=dao.verifyLogin(username, password);
		return ResponseEntity.ok(owner1);
		
	}
}
