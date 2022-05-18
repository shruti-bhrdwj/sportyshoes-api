package com.sportyshoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class User {
	
	@Column(name = "NAME")
	private String uname;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "PASSWORD")
	private String userpwd;
	
	public User() {}
	
	public User(String uname, int userId, String userpwd) {
		super();
		this.uname = uname;
		this.userId = userId;
		this.userpwd = userpwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userId) {
		this.userId = userId;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "\nUser Details: [Name = " + uname + ", UserId=" + userId + " ]";
	}
	
}
