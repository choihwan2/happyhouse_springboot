package com.ssafy.edu.vue.dto;

public class HouseDealInfoDto {
	private String no;
	private String dong;
	private String houseName;
	private String code;
	private String dealAmount;
	private String buildYear;
	private String area;
	private String floor;
	private String jibun;
	private String type;
	

	@Override
	public String toString() {
		return "HouseDealInfoDto [no=" + no + ", dong=" + dong + ", houseName=" + houseName + ", code=" + code
				+ ", dealAmount=" + dealAmount + ", buildYear=" + buildYear + ", area=" + area + ", floor=" + floor
				+ ", jibun=" + jibun + ", type=" + type + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
