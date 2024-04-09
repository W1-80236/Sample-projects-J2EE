package com.sunbeam.pojos;

import java.sql.Date;

public class Movie {
	private int id;
	private String title;
	private Date release;
    public Movie() {
		
	}
	public Movie(int id, String title, Date release) {
		super();
		this.id = id;
		this.title = title;
		this.release = release;
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
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", release=" + release + "]";
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
	}

}
