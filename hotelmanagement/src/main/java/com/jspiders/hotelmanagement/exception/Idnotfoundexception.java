package com.jspiders.hotelmanagement.exception;

public class Idnotfoundexception extends RuntimeException{
	private String message;

	@Override
	   public String getMessage() {
		   return message;
	   }

	  public Idnotfoundexception(String message) {
		this.message = message;
	   }

	   public Idnotfoundexception() {
		  super();
	   }
}
