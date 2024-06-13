package com.app.beans;

import java.util.Date;
import java.util.List;

import com.app.dao.BlogDao;
import com.app.pojos.Blogs;

public class BlogListBeans {
	private List<Blogs> blogList;
	private int id;
	private int userID;
	private int count;
	private String title, contents;

	public void fetchBlogList() {
		try (BlogDao bd = new BlogDao();) {
			blogList = bd.AllBlog();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addBlog() {
		try (BlogDao bd = new BlogDao();) {
			count = bd.addBlogs(new Blogs(title, contents, new Date(), userID, id));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void myBlogList() {
		try (BlogDao bd = new BlogDao();) {
			blogList = bd.AllBlog(id);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void deleteBlogs() {
		try (BlogDao bd = new BlogDao();) {
			count = bd.deleteBlogs(id, userID);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Blogs> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blogs> blogList) {
		this.blogList = blogList;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContents() {
		return contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
