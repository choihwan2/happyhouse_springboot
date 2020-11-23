package com.ssafy.edu.vue.dto;

public class StarHouseDto {
	int no;
	String userId;
	int aptNo;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAptNo() {
		return aptNo;
	}

	public void setAptNo(int aptNo) {
		this.aptNo = aptNo;
	}

	public StarHouseDto() {
		// TODO Auto-generated constructor stub
	}
	public StarHouseDto(int no, String userId, int aptNo) {
		this.no = no;
		this.userId = userId;
		this.aptNo = aptNo;
	}

	@Override
	public String toString() {
		return "StartAptDto{" + "no=" + no + ", userId='" + userId + '\'' + ", aptNo=" + aptNo + '}';
	}
}
