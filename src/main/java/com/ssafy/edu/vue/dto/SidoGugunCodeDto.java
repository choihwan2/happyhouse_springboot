package com.ssafy.edu.vue.dto;

public class SidoGugunCodeDto {

	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;

	public SidoGugunCodeDto() {
		// TODO Auto-generated constructor stub
	}

	public SidoGugunCodeDto(String sidoCode, String sidoName, String gugunCode, String gugunName) {
		super();
		this.sidoCode = sidoCode;
		this.sidoName = sidoName;
		this.gugunCode = gugunCode;
		this.gugunName = gugunName;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

}
