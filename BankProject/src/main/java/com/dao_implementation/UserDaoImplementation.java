package com.dao_implementation;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bean.UserClass;
import com.dao_interface.UserDaoInterface;
import com.objectprovider.SessionProvider;

public class UserDaoImplementation implements UserDaoInterface {
	
	// For connection with database 
	
	
	// Inserting data into database
	public void insertUserData(UserClass user) throws SQLException {
		Session session1 = SessionProvider.getSession();

		try {
			session1.beginTransaction();
			session1.save(user);
			session1.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong!!!");
		} finally {
			session1.close();
		}
	}
	
	// Fetching data from database
	public UserClass userRetrivalDetails(String userName) throws SQLException {
		UserClass user = null;
		Session session2 = SessionProvider.getSession();
		try {
			session2.beginTransaction();
			Query q1 = session2.createQuery("FROM UserClass WHERE name = :userName");
			q1.setParameter("userName", userName);
			user = (UserClass) q1.uniqueResult();
			session2.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong!!!");
		} finally {
			session2.close();
		}
		return user;
	}
	
	// Updating data in the database
	public int updateUserData(String userName, String userPassword) throws SQLException {
		// For getting no. of rows affected
		int count = 0;
		Session session3 = SessionProvider.getSession();
		try {
			session3.beginTransaction();
			Query q2 = session3.createQuery("UPDATE UserClass SET password = :pass WHERE name = :userName");
			q2.setParameter("pass", userPassword);
			q2.setParameter("userName", userName);
			count = q2.executeUpdate();
			session3.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong!!!");
		} finally {
			session3.close();
		}

		return count;
	}
	
	// Deleting data from the database
	public int deleteData(String userName) throws SQLException {
		// For getting no. of rows affected
		int count = 0;
		Session session4 = SessionProvider.getSession();
		try {
			session4.beginTransaction();
			Query q4 = session4.createQuery("DELETE FROM UserClass WHERE name = :userName ");
			q4.setParameter("userName", userName);
			count = q4.executeUpdate();
			session4.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session4.close();
		}
		return count;
	}
	// Author :- Onkar B. Madhekar //
}
