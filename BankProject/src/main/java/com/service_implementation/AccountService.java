package com.service_implementation;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;

import com.bean.Account;
import com.bean.UserClass;
import com.dao_implementation.AccountDaoImplementation;
import com.dao_implementation.UserDaoImplementation;
import com.exception.InvalidAccountNumberException;
import com.exception.ValidDetailException;
import com.exception.WithdrawException;
import com.service_interface.AccountServiceInterface;

public class AccountService implements AccountServiceInterface {
	// Account Instance
	Account account = new Account();
	// DAO Implementation Classes
	AccountDaoImplementation accImp = new AccountDaoImplementation();
	UserDaoImplementation userImp = new UserDaoImplementation();

	// Opening New Account For New User
	public Account openAccount(String accType, float amount, UserClass user) throws ValidDetailException {

		account.setAccType(accType);
		account.setAccBal(amount);
		account.setUser(user);
		System.out.println("Account Number:" + account.getAccNo());
		// returning the account number for user
		return account;
	}

	// Opening New Account For Existing User
	public int openNewAccount(String accType, float amount, String userName) throws ValidDetailException, SQLException {
		// Setting Object Data
		UserClass user = userImp.userRetrivalDetails(userName);
		account.setAccType(accType);
		account.setAccBal(amount);
		account.setUser(user);
		
		try {
			accImp.insertAccountData(account);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		// Returning The Account Number
		return account.getAccNo();
	}
	
	// Display Method
	public String displayAccountDetails(int accNo) throws InvalidAccountNumberException, ValidDetailException {
		String details = null;
		try {
			account = accImp.retriveAccountDetails(accNo);
			if (account != null) {
				details = account.toString();
			} 
			else {
				details = "";
				throw new InvalidAccountNumberException("Invalid Account Number!!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}
	
	// Deposit Method
	public float deposite(int accNo, float balance) throws ValidDetailException, InvalidAccountNumberException {
		float updatedBalance = 0;
		try {
			// fetching details for validating user
			account = accImp.retriveAccountDetails(accNo);
			if (account != null) {
				// updating balance in database
				updatedBalance = account.getAccBal() + balance;
				accImp.updateBalanceData(accNo, updatedBalance);
			} else {
				updatedBalance = 0.0f;
				throw new InvalidAccountNumberException("Invalid Account Number!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// returning the balance
		return updatedBalance;
	}
	
	// Withdraw Method
	public float withdraw(int accNo, float balance)
			throws InvalidAccountNumberException, WithdrawException, ValidDetailException {
		float updatedBalance = 0;
		try {
			// fetching details for validating user
			account = accImp.retriveAccountDetails(accNo);
			if (account != null) {
				// checking for funds
				if (account.getAccBal() <= balance) {
					throw new WithdrawException("Insufficent Balance");
				} else {
					// updating balance in database
					updatedBalance = account.getAccBal() - balance;
					accImp.updateBalanceData(accNo, updatedBalance);
				}

			} 
			else {
				updatedBalance = 0.0f;
				throw new InvalidAccountNumberException("Invalid Account Number!!");
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		// returning the updated balance
		return updatedBalance;
	}
	
	// Balance Inquiry Method
	public float balanceInquiry(int accNo) throws InvalidAccountNumberException, ValidDetailException {
		float balance = 0.0f;
		try {
			// getting the data from data retrieval
			account = accImp.retriveAccountDetails(accNo);
			// validating user
			if (account != null) {
				balance = account.getAccBal();
			} 
			else {
				throw new InvalidAccountNumberException("Invalid account number!!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		// returning the balance
		return balance;

	}
	
	// IFSC CODE Method
	public String getIfscCodeAccount(int accNo) throws InvalidAccountNumberException, ValidDetailException {
		return Account.getIfscCode();
	}
	
	// Delete Account Method
	public boolean deleteAccount(int accNo) throws InvalidAccountNumberException {
		boolean result = false;
		try {
			// getting the data from data retrieval
			account = accImp.retriveAccountDetails(accNo);
			// validating user
			if (account != null) {
				accImp.deleteData(accNo);
				result =true;
			} 
			else {
				throw new InvalidAccountNumberException("Invalid account number!!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result ;

	}

}
//Author :- Onkar B. Madhekar //