package com.example.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class MemberEntity {

	
	@Id
	@Column(name = "memberid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberid;
	
	
	@Column(name = "membername")
	private String membername;
	
	
	@Column(name = "memberemail")
	private String memberemail;
	
	
	@Column(name = "membermobile")
	private String membermobile;
	
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "gender")
	private String gender;


	public Integer getMemberid() {
		return memberid;
	}


	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}


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
