package com.bean;
//Author Onkar B. Madhekar //
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserClass {
	// Data Abstraction
	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "name")
	private String userName;

	@Column(name = "password")
	private String userPassword;

	@Column(name = "security_quetion")
	private String userQuetion;

	@Column(name = "security_answer")
	private String userAnswer;

	@Column(name = "address")
	private String userAddress;

	@Column(name = "pincode")
	private int pinCode;

	static int userIdSeries;

	// static variable declaration
	static {
		userIdSeries = 1;
	}

	// Table Mapping
	@OneToMany(mappedBy = "user")
	private List<Account> accs = new ArrayList<Account>();

	// Constructor
	public UserClass() {
		this.userId = userIdSeries;
		userIdSeries++;
	}

	// Getters-Setters

	public int getUserId() {
		return userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserQuetion() {
		return userQuetion;
	}

	public void setUserQuetion(String userQuetion) {
		this.userQuetion = userQuetion;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public List<Account> getAccs() {
		return accs;
	}

	public void setAccs(List<Account> accs) {
		this.accs = accs;
	}

	// to-string method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userQuetion="
				+ userQuetion + ", userAnswer=" + userAnswer + ", userAddress=" + userAddress + ", pinCode=" + pinCode
				+ "]";
	}
	// Author Onkar B. Madhekar //
}
