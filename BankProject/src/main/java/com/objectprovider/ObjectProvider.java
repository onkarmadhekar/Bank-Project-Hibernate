package com.objectprovider;
//Author :- Onkar B. Madhekar //
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.service_interface.AccountServiceInterface;
import com.service_interface.UserServiceInterface;
import com.service_implementation.*;

public class ObjectProvider {
	
	// UserService Object Provider
	@SuppressWarnings("deprecation")
	public static  UserServiceInterface getUserObject() {
		UserService s =null;
		FileInputStream fis = null;
		try {
			// reading files
			fis = new FileInputStream(".//resources//info.properties");
			Properties p =new Properties();
			// loading file
			p.load(fis);
			String userClass = p.getProperty("user");
			
			// creating instance
			s = (UserService) Class.forName(userClass).newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		//returning instance
		return s;
		
	}
	
	// AccountService Object Provider
	@SuppressWarnings("deprecation")
	public static  AccountServiceInterface getAccountObject() {
		AccountService a =null;
		FileInputStream fis = null;
		try {
			// reading files
			fis = new FileInputStream(".//resources//info.properties");
			Properties p =new Properties();
			// loading file
			p.load(fis);
			String userClass = p.getProperty("account");
			
			// creating instance
			a = (AccountService) Class.forName(userClass).newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		//returning instance
		return a;
		
	}

}
//Author :- Onkar B. Madhekar //
