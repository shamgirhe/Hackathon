package com.app.utils;

import java.sql.SQLException;

import java.util.*;

import com.app.dao.*;
import com.app.pojos.*;

public interface BlogsUtils {

	public static void addBlogs(Scanner sc, BlogDao blogsdao, User user, CategoryDao categorydao) throws SQLException {
		System.out.println("Enter the title ::");
		String title = sc.nextLine();
		System.out.println("Enter the Contents ::");
		String contents = sc.nextLine();
		CategoryUtils.displayCategory(categorydao);
		System.out.println("Enter the Category id :: ");
		int id = sc.nextInt();
		int i = blogsdao.addBlogs(new Blogs(title, contents, new Date(), user.getUserId(), id));
		if (i > 0)
			System.out.println("Blogs is Added SuccessFully!!");
		else
			System.out.println("Blogs is Not Added!!");
	}

	public static void displayBlogs(BlogDao blogsdao, CategoryDao categorydao, UserDao userdao, User user, boolean flag)
			throws SQLException {
		System.out.println("All Blogs are ::");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s%-30s%-40s%-30s%-40s%-20s\n", "ID", "Title", "Category Title", "User Name",
				"Description", "Time");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		if (flag) {
			blogsdao.AllBlog().forEach(s -> {
				try {
					System.out.printf("%-5s%-30s%-40s%-30s%-40s%-20s\n", s.getId(), s.getTitle(),
							categorydao.Categories(s.getCategoryid()), userdao.Users(s.getUser_id()), s.getContents(),
							s.getCreated_date());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		} else {
			blogsdao.AllBlog().stream().filter(s -> s.getUser_id() == user.getUserId()).forEach(s -> {
				try {
					System.out.printf("%-5s%-30s%-40s%-30s%-40s%-20s\n", s.getId(), s.getTitle(),
							categorydao.Categories(s.getCategoryid()), userdao.Users(s.getUser_id()), s.getContents(),
							s.getCreated_date());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static void deleteBlogs(Scanner sc, BlogDao blogsdao, User user) throws SQLException {
		System.out.print("Enter the Blog_id to be deleted ::");
		int id = sc.nextInt();
		int c = blogsdao.deleteBlogs(id, user.getUserId());
		if (c > 0)
			System.out.println("delete the blog is successfully.");
		else
			System.out.println("your not authorised User.");
	}

	public static void readBlog(Scanner sc, BlogDao blogsdao) throws SQLException {
		System.out.println("Enter the Blog_id to be read ::");
		int id = sc.nextInt();
		System.out.println("Fill content as are followed::");
		System.out.println("-------------------------------------------------------------------");
		blogsdao.AllBlog().stream().filter(s -> s.getId() == id).forEach(
				s -> System.out.println("Blog Title: " + s.getTitle() + "\r\nBlog Content:" + s.getContents()));
		System.out.println("-------------------------------------------------------------------");

	}

	public static void editBlog(Scanner sc, BlogDao blogsdao, User user) throws SQLException {
		System.out.print("Enter the Blog id to be Edited :: ");
		int id = sc.nextInt();
		boolean f = blogsdao.editsBlogs(id, user, sc);
		if (f)
			System.out.println("Updated Data SuccessFully Done....");
		else
			System.out.println("your not autications users.");
	}

	public static void serchBlog(Scanner sc, BlogDao blogsdao, UserDao userdao, CategoryDao categorydao)
			throws SQLException {
		System.out.print("Enter the words :: ");
		String word = sc.nextLine();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s%-30s%-40s%-30s%-40s%-20s\n", "ID", "Title", "Category Title", "User Name",
				"Description", "Time");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		blogsdao.AllBlog().stream()
				.filter(s -> ((s.getContents().indexOf(word) != -1) || (s.getTitle().indexOf(word) != -1)))
				.forEach(s -> {
					try {
						System.out.printf("%-5s%-30s%-40s%-30s%-40s%-20s\n", s.getId(), s.getTitle(),
								categorydao.Categories(s.getCategoryid()), userdao.Users(s.getUser_id()),
								s.getContents(), s.getCreated_date());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static void menu() {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println(
				" 0.LogOut\r\n 1.show category\r\n 2.add category.\r\n 3.create blog.\r\n 4.display all blogs.\r\n 5.show my blogs.\r\n 6.delete blogs.\r\n 7.read blog contents.\r\n 8.edit blogs\r\n 9.search blog");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
	}
}
