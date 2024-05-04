package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DbUtils {
	static final String DB_URL = "jdbc:mysql://localhost:3306/hackathon";
	static final String USERNAME = "root";
	static final String PASSWORD = "sham2114";

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
}
