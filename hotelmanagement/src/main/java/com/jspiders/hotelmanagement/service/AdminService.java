package com.jspiders.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.hotelmanagement.dao.Admindao;
import com.jspiders.hotelmanagement.dao.Hoteldao;
import com.jspiders.hotelmanagement.dto.Admin;
import com.jspiders.hotelmanagement.dto.Hotel;
import com.jspiders.hotelmanagement.util.Responsestructure;

@Service
public class AdminService {
	
	@Autowired
	private Admindao admindao;

	@Autowired
	private Hoteldao hoteldao;

	Responsestructure<Admin> responsestructure = new Responsestructure<>();

	public ResponseEntity<Responsestructure<Admin>> saveAdmin(Admin admin, int hid) {
		Hotel hotel = hoteldao.gethotelbyid(hid);
		admin.setHotel(hotel);
		Admin admin2 = admindao.saveAdmin(admin);
		if (admin2 != null) {
			responsestructure.setMessage("admin saved succesfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(admin2);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.CREATED);
		} else {
			return null;
		}

	}

	public ResponseEntity<Responsestructure<Admin>> updateAdmin(int aid, Admin admin) {
		Admin dbAdmin = admindao.getadminbyid(aid);
		admin.setHotel(dbAdmin.getHotel());
		if (dbAdmin != null) {
			admin.setAdmin_id(aid);
			responsestructure.setMessage("updated succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admindao.updateAdmin(admin));
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		} else {
			return null;
		}

	}

	public ResponseEntity<Responsestructure<Admin>> deleteAdmin(int aid) {
		Admin admin = admindao.getadminbyid(aid);
		if (admin != null) {
			responsestructure.setMessage("deleted succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admindao.deleteAdmin(admin));
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		} else {
			return null;
		}

	}

	public ResponseEntity<Responsestructure<Admin>> getadminbyemail(String email) {
		Admin admin = admindao.getAdminbyemail(email);
		if (admin != null) {
			responsestructure.setMessage("found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.FOUND);
		} else {
			return null;
		}

	}

	public ResponseEntity<Responsestructure<List<Admin>>> getallAdmin() {
		Responsestructure<List<Admin>> responsestructure = new Responsestructure<>();
		if (admindao.getalladmin() != null) {
			responsestructure.setMessage("found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admindao.getalladmin());
			return new ResponseEntity<Responsestructure<List<Admin>>>(responsestructure, HttpStatus.FOUND);
		}
		return null;
	}

	public ResponseEntity<Responsestructure<Admin>> loginAdmin(String email, String password) {
		Admin admin = admindao.getAdminbyemail(email);
		if (admin.getAdmin_password().equals(password)) {
			responsestructure.setMessage("admin logged in succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		} else {
			responsestructure.setMessage("enter valid email and password");
			responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responsestructure.setData(null);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<Responsestructure<Admin>> getAdminbyid(int aid) {
		Admin admin = admindao.getadminbyid(aid);
		if (admin != null) {
			responsestructure.setMessage("found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.FOUND);
		} else {
			return null;
		}

	}
	


 
}