package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class BoardDto implements Serializable {
	private int num;
	private String title;
	private String content;
	private String id;
	private String date;
	private int type;
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardDto(int num, String title, String content, String id, String date, int type) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.id = id;
		this.date = date;
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", title=" + title + ", content=" + content + ", id=" + id + ", date=" + date
				+ ", type=" + type + "]";
	}
	
	
	
	

}
