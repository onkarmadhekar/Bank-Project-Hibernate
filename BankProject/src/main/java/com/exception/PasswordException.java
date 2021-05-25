package com.exception;
//Author :- Onkar B. Madhekar //
// Password Exception
@SuppressWarnings("serial")
public class PasswordException extends Exception {
	// data
		String msg;

		// Constructor
		public PasswordException(String msg) {
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