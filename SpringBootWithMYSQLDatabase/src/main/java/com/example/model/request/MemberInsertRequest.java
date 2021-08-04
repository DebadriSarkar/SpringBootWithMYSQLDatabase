package com.example.model.request;

public class MemberInsertRequest {

	
	private String membername;
	private String memberemail;
	private String membermobile;
	private String password;
	private String gender;
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberemail() {
		return memberemail;
	}
	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	public String getMembermobile() {
		return membermobile;
	}
	public void setMembermobile(String membermobile) {
		this.membermobile = membermobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
