package com.app.beans;

import java.sql.SQLException;
import java.util.Date;

import com.app.dao.UserDao;
import com.app.pojos.User;

public class NewUserBeans {
   private String fullName,password,email,phoneNumber;
   private int count;
   
   
   public void insertUser() {
	   try(UserDao ud = new UserDao();) {
		this.count = ud.insertUsers(new User(fullName, email, password, phoneNumber,new Date()));
	} catch (SQLException e) {
		System.out.println("NewUserBeans.insertUser()");
	} catch (Exception e1) {
		System.out.println("error ");
	} 
   }
   
   public String userName(int id) {
	   try(UserDao ud = new UserDao();) {
		return ud.Users(id);
	} catch (SQLException e) {
		System.out.println("NewUserBeans.insertUser()");
	} catch (Exception e1) {
		System.out.println("error ");
	} 
	   return null;
   }
   
   

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
   
   
}
