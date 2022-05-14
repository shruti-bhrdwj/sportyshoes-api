package com.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Orders;
import com.sportyshoes.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	@GetMapping("/all")
	public List<Orders> getProductList()
	{
		return orderService.getAllOrders();
	}

}
