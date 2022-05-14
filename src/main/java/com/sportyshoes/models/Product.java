package com.sportyshoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private int productId;
	
	@Column(name = "MSRP")
	private double msrp;
	
	@Column(name = "PRODUCT_NAME ")
	private String pname;
	
	@Column(name = "VENDOR_INFO")
	private String vendorInfo;
	
	@ManyToOne
    private Orders order;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getVendorInfo() {
		return vendorInfo;
	}

	public void setVendorInfo(String vendorInfo) {
		this.vendorInfo = vendorInfo;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", msrp=" + msrp + ", pname=" + pname + ", vendorInfo=" + vendorInfo
				+ "]";
	}
	
}
