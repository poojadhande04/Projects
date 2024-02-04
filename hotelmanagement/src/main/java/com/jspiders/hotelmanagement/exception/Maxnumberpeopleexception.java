package com.jspiders.hotelmanagement.exception;

public class Maxnumberpeopleexception extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message="We cant have these many number of people in the selected room";

	@Override
	public String getMessage() {
		return message;
	}

	public Maxnumberpeopleexception(String message) {
		super();
		this.message = message;
	}

	public Maxnumberpeopleexception() {
		super();
		
	}
}
