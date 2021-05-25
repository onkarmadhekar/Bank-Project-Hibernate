package com.service_interface;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;

import com.bean.Account;
import com.bean.UserClass;
import com.exception.InvalidAccountNumberException;
import com.exception.ValidDetailException;
import com.exception.WithdrawException;

public interface AccountServiceInterface {
	// Method declaration
	public Account openAccount(String accType, float amount, UserClass user) throws ValidDetailException;

	public int openNewAccount(String accType, float amount, String userName) throws ValidDetailException, SQLException;

	public String displayAccountDetails(int accNo) throws InvalidAccountNumberException, ValidDetailException;

	public float deposite(int accNo, float balance) throws ValidDetailException, InvalidAccountNumberException;

	public float withdraw(int accNo, float balance)
			throws InvalidAccountNumberException, WithdrawException, ValidDetailException;

	public float balanceInquiry(int accNo) throws InvalidAccountNumberException, ValidDetailException;

	public String getIfscCodeAccount(int accNo) throws InvalidAccountNumberException, ValidDetailException;

	public boolean deleteAccount(int accNo) throws InvalidAccountNumberException;

}
//Author :- Onkar B. Madhekar //