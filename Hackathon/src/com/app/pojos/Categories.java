package com.app.pojos;

public class Categories {
	private int id;
	private String title;
	private String descriptions;

	public Categories() {
		// TODO Auto-generated constructor stub
	}

	public Categories(int id, String title, String descriptions) {
		super();
		this.id = id;
		this.title = title;
		this.descriptions = descriptions;
	}

	public Categories(String title, String descriptions) {
		super();
		this.title = title;
		this.descriptions = descriptions;
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

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", title=" + title + ", descriptions=" + descriptions + "]";
	}

}
