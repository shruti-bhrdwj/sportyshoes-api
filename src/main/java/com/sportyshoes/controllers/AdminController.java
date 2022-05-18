package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Admin;
import com.sportyshoes.services.AdminService;
import com.sportyshoes.services.OrderService;
import com.sportyshoes.services.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService admService;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/signIn")
	public String adminLogin(@RequestParam String name, @RequestParam String password)
	{
		if(admService.adminAuth(name, password))
		{
			return "Logged in Successfully";
		}
		else
			return "Login Failed";
	}
	
	@PatchMapping("/{id}/update/password")
	public String changePassword(@PathVariable("id") int id,@RequestParam String oldPassword,@RequestParam String newPassword)
	{
		if(admService.changePassword(id, oldPassword, newPassword))
		{
			return "Password changed successfully";
		}
		else
			return "Request Failed";
		
	}
	
	@GetMapping("/id={admID}")
	public Admin getMyDetails(@PathVariable("admID") int id) {
		return admService.getAdminDetails(id);
	}
	
	@GetMapping("/getUser")
	public String getUserByName(@RequestParam String uname)
	{
		return uService.findUserByName(uname);
	}
	
	@GetMapping("/getUser/{uid}")
	public String getUserById(@PathVariable String uid)
	{
		return uService.findUserById(uid);
	}
	
	@GetMapping("/getAllOrders")
	public String showOrderList()
	{
		return orderService.getAllOrders();
	}

}
