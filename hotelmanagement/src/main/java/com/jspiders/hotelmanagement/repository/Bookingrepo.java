package com.jspiders.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.hotelmanagement.dto.Booking;

public interface Bookingrepo extends JpaRepository<Booking,Integer> {
	
	@Query("select b from Booking b where b.check_in_date=?l")
	public Booking getBookingbycheckin(String check_in_date) ;
	
	@Query("select b from Booking b where b.check_out_date=?l")
	public Booking getBookingbcheckout(String check_out_date);

		
		

}
