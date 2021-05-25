package com.exception;
//Author :- Onkar B. Madhekar //
// Account number exception
@SuppressWarnings("serial")
public class InvalidAccountNumberException extends Exception{
	// data 
	String msg ;
	
	// constructor
	public InvalidAccountNumberException(String msg) {
		super();
		this.msg = msg;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Something has gone wrong [msg=" + msg + "]";
	}
	
}
//Author :- Onkar B. Madhekar //