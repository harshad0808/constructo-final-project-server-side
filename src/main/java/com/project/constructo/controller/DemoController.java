package com.project.constructo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.constructo.model.ConstructOwner;
import com.project.constructo.repository.ConstructoOwnerRepo;

@RestController
@RequestMapping ("/api/v1/")
public class DemoController {
	@Autowired
	ConstructoOwnerRepo obj;
	@GetMapping("/Display")
	public List<ConstructOwner> findAll()
	{
		return obj.findAll();
	}
}
