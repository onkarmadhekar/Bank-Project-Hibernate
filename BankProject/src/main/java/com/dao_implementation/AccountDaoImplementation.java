package com.dao_implementation;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bean.Account;
import com.dao_interface.AccountDaoInterface;
import com.objectprovider.SessionProvider;

public class AccountDaoImplementation implements AccountDaoInterface {

	// For connection with Database
	Session session = SessionProvider.getSession();

	// Inserting Data Into Database
	public void insertAccountData(Account account) throws SQLException {
		Session session1 = SessionProvider.getSession();
		try {
			session1.beginTransaction();
			session1.save(account);
			session1.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong!!!");
		} 
		finally {
			session1.close();
		}

	}

	// Fetching the data from the database
	public Account retriveAccountDetails(int accNo) throws SQLException {
		Account account = null;
		Session session2 = SessionProvider.getSession();
		try {
			session2.beginTransaction();
			Query q1 = session2.createQuery("FROM Account WHERE account_number = :accNo");
			q1.setParameter("accNo", accNo);
			account = (Account) q1.uniqueResult();
			session2.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong!!!");
		} 
		finally {
			session2.close();
		}
		return account;
	}

	// Updating data in the database
	public int updateBalanceData(int accNo, float balance) throws SQLException {
		// For getting no. of rows affected
		int count = 0;
		Session session3 = SessionProvider.getSession();
		try {
			session3.beginTransaction();
			Query q2 = session3.createQuery("UPDATE Account SET balance = :bal WHERE account_number = :accNo");
			q2.setParameter("bal", balance);
			q2.setParameter("accNo", accNo);
			count = q2.executeUpdate();
			session3.getTransaction().commit();
			;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong!!!");
		} 
		finally {
			session3.close();
		}

		return count;
	}

	// Deleting Records
	public int deleteData(int accNo) throws SQLException {
		// For getting no. of rows affected
		int count = 0;
		Session session4 = SessionProvider.getSession();
		try {
			session4.beginTransaction();
			Query q4 = session4.createQuery("DELETE FROM Account WHERE account_number = :accNo ");
			q4.setParameter("accNo", accNo);
			count = q4.executeUpdate();
			session4.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			session4.close();
		}
		return count;
	}
	// Author :- Onkar B. Madhekar //
}
