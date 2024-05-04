package com.app.pojos;

import java.util.Date;
import java.util.Objects;

public class Blogs {
	private int id;
	private String title;
	private String contents;
	private Date created_date;
	private int user_id;
	private int categoryid;

	public Blogs() {
		// TODO Auto-generated constructor stub
	}

	public Blogs(int id, String title, String contents, Date created_date, int user_id, int categoryid) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.created_date = created_date;
		this.user_id = user_id;
		this.categoryid = categoryid;
	}

	public Blogs(String title, String contents, Date created_date, int user_id, int categoryid) {
		super();
		this.title = title;
		this.contents = contents;
		this.created_date = created_date;
		this.user_id = user_id;
		this.categoryid = categoryid;
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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	@Override
	public String toString() {
		return "blogs [id=" + id + ", title=" + title + ", contents=" + contents + ", created_date=" + created_date
				+ ", user_id=" + user_id + ", categoryid=" + categoryid + "]";
	}

}
