package com.exception;
//Author :- Onkar B. Madhekar //
// User Not Found Exception
@SuppressWarnings("serial")
public class UserException extends Exception {
	// data
	String msg;

	// Constructor
	public UserException(String msg) {
		super();
		this.msg = msg;
	}
	
	// toString
	@Override
	public String toString() {
		return "Something has gone wrong [msg=" + msg + "]";
	}
	
	
}
//Author :- Onkar B. Madhekar //