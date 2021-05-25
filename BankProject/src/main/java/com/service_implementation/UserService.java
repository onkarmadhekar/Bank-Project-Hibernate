package com.service_implementation;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;

import com.bean.Account;
import com.bean.UserClass;
import com.dao_implementation.AccountDaoImplementation;
import com.dao_implementation.UserDaoImplementation;
import com.exception.PasswordException;
import com.exception.UserException;
import com.exception.ValidDetailException;
import com.service_interface.UserServiceInterface;
import com.validation.UserValidation;

public class UserService implements UserServiceInterface {
	// User Class Instance
	UserClass user = null;
	AccountService accService = new AccountService();
	// DAO Implementation Classes
	UserDaoImplementation userDaoImp = new UserDaoImplementation();
	AccountDaoImplementation accImp = new AccountDaoImplementation();
	
	// Sign-Up Method
	public boolean userSignUp(String userName, String userPassword, String secQuetion, String secAnswer,
			String address, int pincode, String accType, float balance)
			throws ValidDetailException, UserException, PasswordException {
		
		boolean result = false;
		// validating user name
					if(!UserValidation.isValidUserName(userName)) {
						// validating password
						if(UserValidation.isValidPassword(userPassword)) {
							// Setting User Data
							user = new UserClass();
							user.setUserName(userName);
							user.setUserPassword(userPassword);
							user.setUserQuetion(secQuetion);
							user.setUserAnswer(secAnswer);
							user.setUserAddress(address);
							user.setPinCode(pincode);
							
							Account account = accService.openAccount(accType, balance, user);
							user.getAccs().add(account);
							
							try {
								// inserting users data
								userDaoImp.insertUserData(user);
								accImp.insertAccountData(account);
								result = true;
							}
							catch(SQLException e) {
								e.printStackTrace();
							}
							catch(Exception e) {
								e.printStackTrace();
							}

						}
						// password exception
						else throw new PasswordException("Weak Password!");
					}
					// userName exception
					else throw new UserException("Username Already Exist!");
		return result;
	}
	
	// Login Method
	public boolean userLogin(String userName, String userPassword) throws UserException, ValidDetailException {
		boolean result = false;
		try {
			// Fetching Data 
			user = userDaoImp.userRetrivalDetails(userName);
			if(user!=null) {
				// validating user 
				result = (user.getUserPassword().contentEquals(userPassword)) ? true : false;
			}
			else {
				throw new UserException("User Not Found!!");
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	// Forget-Password Method
	public boolean forgetPassword(String userName, String secQuetion, String secAnswer)
			throws UserException, ValidDetailException {
		boolean result = false;
		try {
			// fetching data using containment
			user = userDaoImp.userRetrivalDetails(userName);
			if(user!=null) {
				// validating user 
				if(user.getUserQuetion().contentEquals(secQuetion) && user.getUserAnswer().contentEquals(secQuetion)) {
					userDaoImp.updateUserData(userName,"Password@1234");
					result =true;
				}
			}
			else {
				result = false;
				throw new UserException("User not found");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// Update-Password Method
	public boolean updatePassword(String userName, String userPassword, String confirmPassword)
			throws UserException, ValidDetailException {
		boolean result = false;
		try {
			// fetching data (containment)
			user = userDaoImp.userRetrivalDetails(userName);
			if(user!=null) {
				// password validation
				if(userPassword.contentEquals(confirmPassword)&&UserValidation.isValidPassword(userPassword)) {
					userDaoImp.updateUserData(userName,userPassword);
					result =true;
				}
			}
			else {
				result = false;
				throw new UserException("Password does not match!!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
	}
	
		return result;
	}

	

}
//Author :- Onkar B. Madhekar //