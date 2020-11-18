package com.ssafy.edu.vue.dto;

public class CoronaDto {
	private String gugun;
	private String name;
	private String address;
	private String weekdayop;
	private String tel;
	private String lat;
	private String lng;
	private String type;
	

	@Override
	public String toString() {
		return "CoronaDto [gugun=" + gugun + ", name=" + name + ", address=" + address + ", weekdayop=" + weekdayop
				+ ", tel=" + tel + ", lat=" + lat + ", lng=" + lng + ", type=" + type + "]";
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWeekdayop() {
		return weekdayop;
	}

	public void setWeekdayop(String weekdayop) {
		this.weekdayop = weekdayop;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
