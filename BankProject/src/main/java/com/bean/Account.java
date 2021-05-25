package com.bean;

// Author Onkar B. Madhekar //
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	// Data Abstraction
	@Id
	@Column(name = "account_number")
	private int accNo;

	@Column(name = "account_type")
	private String accType;

	@Column(name = "balance")
	private float accBal;

	static int accNoSeries;

	// Mapping the entities
	@ManyToOne
	private UserClass user;

	// static variables
	static String ifscCode;

	// static variable initialization
	static {
		ifscCode = "BKID0066";
		accNoSeries = 600;
	}

	// Constructor
	public Account() {
		this.accNo = accNoSeries;
		accNoSeries++;
	}

	// getters and setters
	public int getAccNo() {
		return accNo;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAccType() {
		return accType;
	}

	public void setUser(UserClass user) {
		this.user = user;
	}

	public UserClass getUser() {
		return user;
	}

	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}

	public float getAccBal() {
		return accBal;
	}

	public static String getIfscCode() {
		return ifscCode;
	}

	// TO String
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", accBal=" + accBal + ", user=" + user + "]";
	}
	// Author Onkar B. Madhekar //
}
