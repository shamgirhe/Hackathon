package com.app.utils;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.CategoryDao;
import com.app.pojos.Categories;

public interface CategoryUtils {

	public static void displayCategory(CategoryDao categorydao) throws SQLException {
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-20s %-40s\n", "id", "Title", "Descreption");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		categorydao.showCategories().forEach(s -> System.out.printf("%-5s %-20s %-40s\n", s.getId(),
				s.getTitle(), s.getDescriptions()));
		System.out.println(
				"--------------------------------------------------------------------------------------------");
	}
	public static void addCategory(Scanner sc , CategoryDao categorydao) throws SQLException {
		System.out.print("Enter the Title for Category ::");
		String title = sc.nextLine();
		System.out.print("Enter the description for Category ::");
		String desc = sc.nextLine();
		int i = categorydao.addCategory(new Categories(title, desc));
		if (i > 0) {
			System.out.println("*** Category is added. ****");
			displayCategory(categorydao);
		}
		else 
			System.out.println("*** Category is not added. ****");
			
	}
}
