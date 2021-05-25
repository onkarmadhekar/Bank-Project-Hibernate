package com.dao_interface;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;

import com.bean.Account;

// DAO Interface For Account
public interface AccountDaoInterface {

	void insertAccountData(Account acc) throws SQLException;

	Account retriveAccountDetails(int accNo) throws SQLException;

	int updateBalanceData(int accNo, float balance) throws SQLException;

	int deleteData(int accNo) throws SQLException;

}
//Author :- Onkar B. Madhekar //