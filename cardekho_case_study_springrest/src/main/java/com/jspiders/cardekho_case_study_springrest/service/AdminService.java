package com.jspiders.cardekho_case_study_springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_springrest.pojo.AdminPOJO;
import com.jspiders.cardekho_case_study_springrest.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository repository;

	public AdminPOJO createAccount(AdminPOJO pojo) {
		AdminPOJO admin=repository.createAccount(pojo);
		return admin;
	}

	public AdminPOJO login(AdminPOJO pojo) {
		AdminPOJO admin=repository.login(pojo);
		
		return admin;
	}

}
