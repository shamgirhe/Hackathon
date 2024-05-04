package com.app.utils;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.app.dao.UserDao;
import com.app.pojos.User;

public interface UsersUtils {

	public static void UserRegister(Scanner sc, UserDao userdao) throws SQLException {
		System.out.print("Enter Your Full Name ::");
		String fullName = sc.nextLine();
		System.out.print("Enter Your Email ::");
		String email = sc.nextLine();
		System.out.print("Enter Your Password ::");
		String password = sc.nextLine();
		System.out.print("Enter Your Mobile Number ::");
		String phoneNumber = sc.nextLine();

		int i = userdao.insertUsers(new User(fullName, email, password, phoneNumber, new Date()));
		if (i > 0)
			System.out.println("**********Register is done***************");
		else
			System.out.println("**********User Credential is Wrongs************");
	}

	public static User UserLogin(Scanner sc, UserDao userdao) throws SQLException {
		System.out.print("Enter your email ::");
		String email = sc.nextLine();
		System.out.print("Enter your Passwords ::");
		String password = sc.nextLine();
		return userdao.login(email, password);
	}
	
	public static void displayUsers(UserDao userdao) throws SQLException{
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-25s %-30s %-20s %-25s\n", "id", "full name", "email", "phone no", " created time");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		userdao.allUsers().forEach(s -> System.out.printf("%-5s %-25s %-30s %-20s %-25s\n", s.getUserId(),
				s.getFullName(), s.getEmail(), s.getPhoneNumber(), s.getCreated_time()));
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static boolean Exits() {
		System.out.println("*-*-*-*-*-*-*-*-*-*-");
		System.out.println("Thanks you.");
		System.out.println("*-*-*-*-*-*-*-*-*-*-");
		return false;
	}

	public static void menu() {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("0.Exits\r\n1.Login\r\n2.Register.\r\n3.All Users.");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("Enter your choice::");

	}
}
