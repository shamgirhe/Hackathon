package com.app.tester;

import java.sql.SQLException;
import java.util.*;

import com.app.dao.*;
import com.app.pojos.*;
import com.app.utils.*;

public class Tester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		try (UserDao userdao = new UserDao(); CategoryDao categorydao = new CategoryDao(); BlogDao blogdao = new BlogDao();) {
			while (flag) {
				UsersUtils.menu();
				switch (sc.nextInt()) {
				case 0:
					flag = UsersUtils.Exits();
					break;
				case 1: {
					sc.nextLine();
					User user = UsersUtils.UserLogin(sc, userdao);
					if (user != null) {
						boolean flag1 = true;
						while (flag1) {
							BlogsUtils.menu();
							System.out.println("*-*-*-*-*-*-*-*");
							System.out.println("*[* Login user Name is " + user.getFullName() + " *]*");
							System.out.println("Enter your Choice ::");
							switch (sc.nextInt()) {
							case 0:
								flag1 = UsersUtils.Exits();
								user = null;
								break;
							case 1:
								CategoryUtils.displayCategory(categorydao);
								break;
							case 2:
								sc.nextLine();
								CategoryUtils.addCategory(sc, categorydao);
								break;
							case 3:
								sc.nextLine();
								BlogsUtils.addBlogs(sc, blogdao, user, categorydao);
								break;
							case 4:
								BlogsUtils.displayBlogs(blogdao, categorydao,userdao, user, true);
								break;
							case 5:
								BlogsUtils.displayBlogs(blogdao, categorydao,userdao, user, false);
								break;
							case 6:
								sc.nextLine();
								BlogsUtils.deleteBlogs(sc, blogdao, user);
								break;
							case 7:
								sc.nextLine();
								BlogsUtils.readBlog(sc, blogdao);
								break;
							case 8:
								sc.nextLine();
								BlogsUtils.editBlog(sc, blogdao, user);
								break;
							case 9:
								sc.nextLine();
								BlogsUtils.serchBlog(sc, blogdao,userdao,categorydao);
								break;

							default:
								System.out.println("Invalid Choice !!!");
								break;
							}
						}
					} else
						System.out.println("User Credential are wrongs!!!!");

				}
					break;
				case 2:
					sc.nextLine();
					UsersUtils.UserRegister(sc, userdao);
					break;
				case 3:
					UsersUtils.displayUsers(userdao);
					break;
				default:
					System.out.println("Invalid Choice ::");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
