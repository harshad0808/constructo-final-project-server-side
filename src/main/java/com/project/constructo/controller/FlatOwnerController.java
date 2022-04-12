package com.project.constructo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.constructo.dao.LocalDao;
import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.FlatCount;
import com.project.constructo.model.FlatOwner;
import com.project.constructo.repository.FlatCountRepo;
import com.project.constructo.repository.FlatOwnerRepo;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/flat")
public class FlatOwnerController {

	@Autowired
	FlatOwnerRepo flatobj;
	
	@Autowired 
	FlatCountRepo count;
	
	@Autowired
	LocalDao dao;
	
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
	
	@GetMapping("/construct/{cid}")
	public List<FlatOwner> getFlatOwnerByConstructId(@PathVariable Long cid)
	{
		List<FlatOwner> owner=dao.getFlatOwnerByConstructId(cid);
		return owner;
		
	}
	
	
	
	@PostMapping("/add")
	public FlatOwner addUser(@RequestBody FlatOwner owner)
	{
		long temp=owner.getcOwner().getC_id();
		
		FlatCount obj=dao.getCount(temp);
		int current_count= obj.getCount();
		++current_count;
		obj.setCount(current_count);
		owner.setUsr_Key(current_count);
		count.save(obj);
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
	
	@PostMapping("/loginflat")
	public ResponseEntity<FlatOwner> checkLogin(@RequestBody FlatOwner owner)
	{
		int key=owner.getUsr_Key();
		String password=owner.getUsr_Password();
		FlatOwner owner1=dao.verifyLoginFlat(key, password);
		return ResponseEntity.ok(owner1);
		
	}
	
	@PostMapping("/validateAccount")
	public ResponseEntity<FlatOwner> validateAccount(@RequestBody FlatOwner tempowner)
	{
		int key=tempowner.getUsr_Key();
		String password=tempowner.getUsr_Password();
		FlatOwner owner=dao.validateAccount(key);
		owner.setUsr_Password(password);
		flatobj.save(owner);
		
		
		
		return ResponseEntity.ok(owner);
		
		
	}
	
	
	
}
