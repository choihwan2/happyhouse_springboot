package com.ssafy.edu.vue.dto;

public class HouseInfoDto {

	private String no;
	private String dong;
	private String houseName;
	private String code;
	private String buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;

	@Override
	public String toString() {
		return "HouseInfoDto [no=" + no + ", dong=" + dong + ", houseName=" + houseName + ", code=" + code + ", buildYear="
				+ buildYear + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng + ", img=" + img + "]\n";
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

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
