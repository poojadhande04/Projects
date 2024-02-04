package com.jspiders.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.hotelmanagement.dto.Customer;

public interface Customerrepo extends JpaRepository<Customer,Integer> {
	
	@Query("select c from Customer c where c.c_email=?l")
	public Customer getCustomerbyemail(String c_email);

}
