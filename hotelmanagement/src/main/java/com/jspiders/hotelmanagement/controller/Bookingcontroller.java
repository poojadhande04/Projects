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

import com.jspiders.hotelmanagement.dto.Booking;
import com.jspiders.hotelmanagement.service.BookingService;
import com.jspiders.hotelmanagement.util.Responsestructure;

@Controller
@RequestMapping("/booking")
public class Bookingcontroller {
	
	@Autowired
	private BookingService bookingservice;

	@PostMapping
	public ResponseEntity<Responsestructure<Booking>> saveBooking(@RequestBody Booking booking,@RequestParam int cid, @RequestParam int rid) {
		return bookingservice.saveBooking(booking, cid, rid);
		
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Booking>> updateBooking(@RequestBody Booking booking, @RequestParam int bid) {
		return bookingservice.updateBooking(booking, bid);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Booking>> deleteBooking(@RequestParam int bid) {
		return bookingservice.deleteBooking(bid);
	}
	
	@GetMapping("/bookingbyid")
	public ResponseEntity<Responsestructure<Booking>> getBookingbyid(@RequestParam int bid) {
		return bookingservice.getBookingbyid(bid);
		
	}
	@GetMapping("/getallbooking")
	public ResponseEntity<Responsestructure<List<Booking>>> getallBookings() {
		return bookingservice.getallbooking();
	}

	
	@GetMapping("/closrbooking")
	public ResponseEntity<Responsestructure<Booking>> closeBooking(@RequestParam int bid) {
		return bookingservice.closeBooking(bid);
		
	}
}
