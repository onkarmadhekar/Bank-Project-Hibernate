package com.exception;
//Author :- Onkar B. Madhekar //
// Valid Details Exception
@SuppressWarnings("serial")
public class ValidDetailException extends Exception {
	// data
	String msg ;
	
	// constructor
	public ValidDetailException(String msg) {
		super();
		this.msg = msg;
	}
	
	// toString
	@Override
	public String toString() {
		return "Something went wrong:[msg=" + msg + "]";
	}
	

}
//Author :- Onkar B. Madhekar //
