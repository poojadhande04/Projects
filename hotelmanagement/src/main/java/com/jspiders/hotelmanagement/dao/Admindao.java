package com.jspiders.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.hotelmanagement.dto.Admin;
import com.jspiders.hotelmanagement.repository.Adminrepo;

@Repository
public class Admindao {
	@Autowired
    private Adminrepo adminrepo;
	
	public Admin saveAdmin(Admin admin) {
		return adminrepo.save(admin);
		
	}
    public Admin updateAdmin(Admin admin) {
    	return adminrepo.save(admin);
		
	}
    public Admin deleteAdmin(Admin admin) {
        adminrepo.delete(admin);
        return admin;
	}
    
    public Admin getadminbyid(int admin_id) {
        if(adminrepo.findById(admin_id).isPresent()) {
        	return adminrepo.findById(admin_id).get();
        }		
        return null;
	}
    
    public List<Admin> getalladmin() {
		return adminrepo.findAll();
	}
    
    public Admin getAdminbyemail(String admin_email) {
        if(adminrepo.getAdminbyemail(admin_email)!=null) {
        	return adminrepo.getAdminbyemail(admin_email); 
        }		
        return null;
	}
	
}
