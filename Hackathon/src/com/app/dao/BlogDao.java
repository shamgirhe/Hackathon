package com.app.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.app.pojos.Blogs;
import com.app.pojos.User;
import com.app.utils.DbUtils;

public class BlogDao implements AutoCloseable {

	private Connection connection;
	private String query;

	public BlogDao() throws SQLException {

		this.connection = DbUtils.getConnection();
	}

	public int addBlogs(Blogs b) throws SQLException {
		query = "INSERT INTO blogs(title,contents,created_time,user_id,category_id) VALUES(?,?,?,?,?);";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getContents());
			stmt.setTimestamp(3, new Timestamp(b.getCreated_date().getTime()));
			stmt.setInt(4, b.getUser_id());
			stmt.setInt(5, b.getCategoryid());
			return stmt.executeUpdate();
		}
	}

	public int deleteBlogs(int id, int userid) throws SQLException {
		query = "delete from blogs where id =? and user_id= ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.setInt(2, userid);
			return stmt.executeUpdate();

		}
	}

	public List<Blogs> AllBlog() throws SQLException {
		query = "select * from blogs";
		List<Blogs> list = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Blogs s = new Blogs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5),
						rs.getInt(6));
				list.add(s);
			}
		}
		return list;
	}

	public boolean editsBlogs(int id, User user, Scanner sc) throws SQLException {
		sc.nextLine();
		query = "UPDATE blogs SET contents = ?, created_time = ? WHERE id = ? AND user_id = ?";
		boolean flag = false;
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			System.out.println("Writes new contents in blogs ::");
			String newContents = sc.nextLine();
			stmt.setString(1, newContents);
			stmt.setTimestamp(2, new Timestamp(new Date().getTime()));
			stmt.setInt(3, id);
			stmt.setInt(4, user.getUserId());
			int rs = stmt.executeUpdate();
			if (rs > 0)
				flag = true;
		}
		return flag;
	}

	@Override
	public void close() throws Exception {
		connection.close();
		
	}

}
