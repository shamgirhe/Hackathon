package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Blogs;
import com.app.pojos.Categories;
import com.app.utils.DbUtils;

public class CategoryDao implements AutoCloseable {

	private Connection connection;
	private String query;

	public CategoryDao() throws SQLException {
		this.connection = DbUtils.getConnection();
	}

	public int addCategory(Categories b) throws SQLException {
		query = "insert into categories(title,description) values(?,?);";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getDescriptions());
			return stmt.executeUpdate();
		}
	}

	public List<Categories> showCategories() throws SQLException {
		query = "select * from categories";
		List<Categories> list = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categories s = new Categories(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(s);
			}
		}
		return list;
	}
	public String Categories(int id) throws SQLException {
		query = "select * from categories where id = ?";
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
