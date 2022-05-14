package com.sportyshoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Column(name="NAME")
	private String adminName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADMIN_ID")
	private int adminId;
	
	@Column(name="PASSWORD")
	private String adminPwd;
	
	public Admin() {}

	public Admin(String adminName, int adminId, String adminPwd) {
		super();
		this.adminName = adminName;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminId=" + adminId + ", adminPwd=" + adminPwd + "]";
	}
	

}
