package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.User;
import com.app.utils.DbUtils;

public class UserDao implements AutoCloseable {
	private Connection connection;
	private String query;

	public UserDao() throws SQLException {
		this.connection = DbUtils.getConnection();
	}

	public int insertUsers(User s) throws SQLException {
		String sql = "INSERT INTO users(Full_Name,email,password,phone_number,created_time) VALUES(?,?,?,?,?);";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, s.getFullName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getPassword());
			stmt.setString(4, s.getPhoneNumber());
			stmt.setTimestamp(5, new Timestamp(s.getCreated_time().getTime()));
			return stmt.executeUpdate();
		}
	}

	public User login(String email, String password) throws SQLException {
		query = "select * from users where email =? and password = ?";
		User user = null;
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			 while(rs.next())
				 user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6));
		}
		return user;
	}

	public List<User> allUsers() throws SQLException {
		query = "select * from users";
		List<User> list = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User s = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getTimestamp(6));
				list.add(s);
			}
		}
		return list;
	}
	public String Users(int id) throws SQLException {
		query = "select * from users where id = ?";
		String name = null;
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			  name = rs.getString(2);
			}
		return name;
	}
	
	@Override
	public void close() throws Exception {
		connection.close();
	}

}
