package com.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Orders;
import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;
import com.sportyshoes.repositories.OrderRepository;
import com.sportyshoes.repositories.ProductRepository;
import com.sportyshoes.repositories.UserRepository;

@Service
public class OrderService {
	
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository uRepository;
	
	public boolean buyProduct(int pid,int uid) {
		Product pr = productRepository.findById(pid).get();
		User us = uRepository.findById(uid).get();
		Orders od = new Orders();
		od.setProduct(pr);
		od.setUser(us);
		od.getDate();
		od.getOrderNum();
		orderRepository.save(od);
		
		if(orderRepository.save(od)== null) {
			return false;
		}else {
			return true;
		}
	}
	
	public List<Orders> getAllOrders() {
		return (List<Orders>) orderRepository.findAll();
	}
	
	

}
