package com.app.pojos;

import java.util.Date;

;

public class User {
	private int userId;
	private String fullName;
	private String email;
	private String password;
	private String phoneNumber;
	private Date created_time;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String fullName, String email, String password, String phoneNumber, Date created_time) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.created_time = created_time;
	}

	public User(String fullName, String email, String password, String phoneNumber, Date created_time) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.created_time = created_time;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", created_time=" + created_time + "]";
	}

}
