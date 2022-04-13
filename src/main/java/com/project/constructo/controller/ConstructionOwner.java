package com.project.constructo.controller;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.constructo.dao.Construct_Owner_Dao;
import com.project.constructo.dao.LocalDao;
import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.FlatCount;
import com.project.constructo.model.Updates;
import com.project.constructo.repository.ConstructoOwnerRepo;
import com.project.constructo.repository.FlatCountRepo;
import com.project.constructo.service.Constr_Owner_Service_impl;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/construction")
public class ConstructionOwner {

	@Autowired
	ConstructoOwnerRepo obj; //change the name
	
	@Autowired
	private Constr_Owner_Service_impl constrservice;
	
	@Autowired
	private Construct_Owner_Dao cnstrowner;
	
	
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
	
	
	@GetMapping("/notverified")
	public List<ConstructOwner> findnotverified()
	{
		return dao.getnotverified();
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
	
	@GetMapping(value="/generateotp/{email}")
	public ResponseEntity<?> generateOtp(@PathVariable String email){
		System.out.println("email: "+email);
		int randomNumber=constrservice.validateEmailAndGenearateOtp(email);
		System.out.println(randomNumber);
		if(randomNumber!=-1)
		return ResponseEntity.ok(randomNumber);
		else
			return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	@PutMapping(value="/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody ConstructOwner credentials ){
		if(constrservice.changePassword(credentials.getEmail(),credentials.getC_Password()))
		return ResponseEntity.ok("password chaange successfully");
		else
			return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	
	@PostMapping("/update")
	public boolean addUpdates(@RequestBody MultipartFile img,String details,String UpdateDate,Long id) {
			Updates update = new Updates();
	try {
		
		String fileName = img.getOriginalFilename();
		FileCopyUtils.copy(img.getInputStream(), new FileOutputStream("D:\\CDAC  JUHU\\Final Project\\Client Side\\react\\constructo\\public\\images\\"+fileName));
		update.setImg(fileName);
		
		update.setUpdateDate(UpdateDate);
		update.setDetails(details);
		ConstructOwner owner=new ConstructOwner();
		owner.setC_id(id);
		update.setcOwnerUpdate(owner);
		constrservice.addUpdate(update);
		
		
		return true;
	}catch(Exception e) {
		System.out.println(e.getMessage());
		return false;
	}
	
	}
	@GetMapping("/images/{c_id}")
	public List<Updates> addimages(@PathVariable long c_id) {
		System.out.println("p:"+c_id);
		return constrservice.fetchImage(c_id);
		
		
		
		
	}
}
