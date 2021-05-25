package com.service_interface;
//Author :- Onkar B. Madhekar //
import com.exception.PasswordException;
import com.exception.UserException;
import com.exception.ValidDetailException;

public interface UserServiceInterface {
	// Method Declaration
	boolean userSignUp(String userName, String userPassword, String secQuetion, String secAnswer, String address,
			int pincode, String accType, float balance) throws ValidDetailException, UserException, PasswordException;

	boolean userLogin(String userName, String userPassword) throws UserException, ValidDetailException;

	boolean forgetPassword(String userName, String secQuetion, String secAnswer)
			throws UserException, ValidDetailException;

	boolean updatePassword(String userName, String userPassword, String confirmPassword)
			throws UserException, ValidDetailException;

}
//Author :- Onkar B. Madhekar //