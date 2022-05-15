package com.sportyshoes.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="customer_orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ORDER_NUMBER")
	private int orderNum;
	

	@Column(name="DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@UpdateTimestamp
	private Timestamp date;
	
	//@ManyToOne
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BY_USER", referencedColumnName = "USER_ID")
    private User user;
	
	//@ManyToOne
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;
	
	public Orders() {}

	public Orders(int orderNum, Timestamp date, User user, Product product) {
		super();
		this.orderNum = orderNum;
		this.date = date;
		this.user = user;
		this.product = product;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Orders [orderNum=" + orderNum + ", date=" + date + ", user=" + user + ", product=" + product + "]";
	}	
	
}
