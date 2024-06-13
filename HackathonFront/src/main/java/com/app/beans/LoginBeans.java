package com.app.beans;

import javax.servlet.http.HttpSession;

import com.app.dao.UserDao;
import com.app.pojos.User;


public class LoginBeans {
	private String email;
	private String password;
	private User user;

	public void loginAuth() throws Exception {
        
		try (UserDao userdao = new UserDao();) {
			 this.user = userdao.login(email, password);
		}
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
