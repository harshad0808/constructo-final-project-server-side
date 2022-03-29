package com.project.constructo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.FlatOwner;
import com.project.constructo.repository.FlatOwnerRepo;

@RestController
@RequestMapping("/flat")
public class FlatOwnerController {

	@Autowired
	FlatOwnerRepo flatobj;
	
	@GetMapping("/users")
	public List<FlatOwner> findAll()
	{
		return flatobj.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FlatOwner> getFlatOwnerById(@PathVariable Long id)
	{
		FlatOwner owner=flatobj.findById(id).orElseThrow();
		return ResponseEntity.ok(owner);
		
	}
	
	@PostMapping("/add")
	public FlatOwner addUser(@RequestBody FlatOwner owner)
	{
		
		return flatobj.save(owner);
		
	}
	
	@PutMapping("/updateData")
	public ResponseEntity<FlatOwner> updateFlatPaidAmount(@PathVariable Long id,@RequestBody FlatOwner tempowner)
	{
		FlatOwner owner=flatobj.findById(id).orElseThrow();
		
		
		owner.setNext_installment(tempowner.getNext_installment());
		owner.setPaid_amount(tempowner.getPaid_amount());
		return ResponseEntity.ok(owner);
		
		
	}
}
