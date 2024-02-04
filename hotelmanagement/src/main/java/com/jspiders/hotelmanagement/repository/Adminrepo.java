package com.jspiders.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.hotelmanagement.dto.Admin;

public interface Adminrepo extends JpaRepository<Admin,Integer> {
	
	@Query("select a from Admin a where a.admin_email=?l")
	public Admin getAdminbyemail(String admin_email);
}
