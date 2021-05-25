package com.exception;
//Author :- Onkar B. Madhekar //
// withdraw exception
@SuppressWarnings("serial")
public class WithdrawException extends Exception {
	
	// data
	String msg;
	
	// constructor
	public WithdrawException(String msg) {
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