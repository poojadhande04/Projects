package com.jspiders.cardekho_case_study_springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho_case_study_springrest.pojo.AdminPOJO;
import com.jspiders.cardekho_case_study_springrest.response.AdminResponse;
import com.jspiders.cardekho_case_study_springrest.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService service;
	
	@PostMapping(path="/createAccount",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAccount(@RequestBody AdminPOJO pojo){
		AdminPOJO admin=service.createAccount(pojo);
		//success
		if(admin !=null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account created successfully",admin),HttpStatus.ACCEPTED);
		}
		//failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account not created",null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@PostMapping(path="/login",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<AdminResponse> login(@RequestBody AdminPOJO pojo){
		AdminPOJO admin=service.login(pojo);
		//success
		if(admin !=null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Login successfully",admin),HttpStatus.OK);
		}
		//failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("Login failed",null),HttpStatus.NOT_FOUND);
	}
	

}
