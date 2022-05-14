package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Admin;
import com.sportyshoes.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService admService;
	
	@PostMapping("/login")
	public String adminLogin(@RequestParam String name, @RequestParam String password)
	{
		if(admService.adminAuth(name, password))
		{
			return "Logged in Successfully";
		}
		else
			return "Login Failed";
	}
	
	@PostMapping("/changePassword/{id}&{newPassword}")
	public String changePassword(@PathVariable("id") int id, @PathVariable("newPassword") String newPassword)
	{
		admService.changePassword(id, newPassword);
		return "Password Changed Successfully";
	}
	
	@GetMapping("/id={admID}")
	public Admin getDetails(@PathVariable("admID") int id) {
		return admService.getAdminDetails(id);
	}

}
