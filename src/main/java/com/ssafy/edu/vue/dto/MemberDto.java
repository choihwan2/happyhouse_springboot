package com.ssafy.edu.vue.dto;
//DTO -VO 
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String addressDetail;
	private int isAdmin;
	
	public MemberDto() {
	}
	public MemberDto(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public MemberDto(String id, String pw, String name, String phoneNum, String email, String address, String addressDetail,
			int isAdmin) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.addressDetail = addressDetail;
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phoneNum=" + phoneNum + ", email=" + email
				+ ", address=" + address + ", addressDetail=" + addressDetail + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
