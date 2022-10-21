package com.example.PyronmentDocumentGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PyronmentDocumentGenerator.service.PyronmentService;

@RestController
public class PyronmentController {

	@Autowired
	PyronmentService pyronmentService;
	
	
	@PostMapping("/save")
	public void saveData() {			
		pyronmentService.saveData();		
		System.out.println("Data saved sucessfully");
		
		
	}
	
	
	
	
	
}
