package com.app.pojos;

import java.util.Date;
import java.util.Objects;

public class Blogs {
	private int id;
	private String title;
	private String contents;
	private Date createdDate;
	private int userId;
	private int categoryId;

	public Blogs() {
		// TODO Auto-generated constructor stub
	}

	public Blogs(int id, String title, String contents, Date createdDate, int userId, int categoryId) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.userId = userId;
		this.categoryId = categoryId;
	}

	public Blogs(String title, String contents, Date createdDate, int userId, int categoryId) {
		super();
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.userId = userId;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getcreatedDate() {
		return createdDate;
	}

	public void setcreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public int getcategoryId() {
		return categoryId;
	}

	public void setcategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "blogs [id=" + id + ", title=" + title + ", contents=" + contents + ", createdDate=" + createdDate
				+ ", userId=" + userId + ", categoryId=" + categoryId + "]";
	}

}
