package com.validation;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.UserClass;
import com.dao_implementation.UserDaoImplementation;

public class UserValidation {
	// code for input validation
	public static boolean isValidUserName(String userName) {
		boolean result = false;
		// connecting to database
		UserDaoImplementation userImp = new UserDaoImplementation();
		UserClass user = null;

		try {
			// prepared statement
			user = userImp.userRetrivalDetails(userName);
			result = (user != null) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of isValidUsername method
	
	
	// Password Validation
	public static boolean isValidPassword(String password) {

		// Regular Expression to check valid password.
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the password is empty
		// return false
		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);
		// matched the ReGex
		return m.matches();
	}
}
//Author :- Onkar B. Madhekar //