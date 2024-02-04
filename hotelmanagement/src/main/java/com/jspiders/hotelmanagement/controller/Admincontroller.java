package com.jspiders.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.hotelmanagement.dto.Admin;
import com.jspiders.hotelmanagement.service.AdminService;
import com.jspiders.hotelmanagement.util.Responsestructure;

@Controller
@RequestMapping("/admin")
public class Admincontroller {
	@Autowired
	private AdminService adminservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Admin>> saveAdmin(@RequestBody Admin admin, @RequestParam int hid) {
		return adminservice.saveAdmin(admin, hid);
	}
	@PutMapping
	public ResponseEntity<Responsestructure<Admin>> updateAdmin(@RequestParam int aid,@RequestBody Admin admin) {
		return adminservice.updateAdmin(aid, admin);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Admin>> deleteAdmin(@RequestParam int aid) {
		return adminservice.deleteAdmin(aid);
	}
	
	@GetMapping("/adminbyid")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyid(@RequestParam int aid) {
		return adminservice.getAdminbyid(aid);

	}

	@GetMapping("/adminbyemail")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyemail(@RequestParam String email) {
		return adminservice.getadminbyemail(email);

	}

	@GetMapping("/getalladmin")
	public ResponseEntity<Responsestructure<List<Admin>>> getallAdmin() {
		return adminservice.getallAdmin();
	}

	@GetMapping("/loginadmin")
	public ResponseEntity<Responsestructure<Admin>> loginAdmin(@RequestParam String email, @RequestParam String password) {
		return adminservice.loginAdmin(email, password);

	}

}
