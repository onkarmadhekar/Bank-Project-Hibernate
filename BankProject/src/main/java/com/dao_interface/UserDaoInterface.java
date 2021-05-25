package com.dao_interface;
//Author :- Onkar B. Madhekar //
import java.sql.SQLException;

import com.bean.UserClass;

// DAO Interface For User Class
public interface UserDaoInterface {
	void insertUserData(UserClass user) throws SQLException;

	UserClass userRetrivalDetails(String userName) throws SQLException;

	int updateUserData(String userName, String userPassword) throws SQLException;

	int deleteData(String userName) throws SQLException;

}
//Author :- Onkar B. Madhekar //