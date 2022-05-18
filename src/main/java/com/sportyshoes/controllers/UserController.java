package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.User;
import com.sportyshoes.services.OrderService;
import com.sportyshoes.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/signUp")
	public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam String password)
	{
		User user= userService.addUser(name, password);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@PostMapping("/signIn")
	public String userLogin(@RequestParam String name, @RequestParam String password) {
		if(userService.userAuth(name, password)){
			return "Logged in Successfully";
		} else 
			return "Login Failed";
	}
	
	@GetMapping("/all")
	public String getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userID}")
	public String viweDetails(@PathVariable("userID") String id) {
			return userService.findUserById(id);	
	}
	
	@PostMapping("/{userID}/product/{productID}/order")
	public String productPurchase(@PathVariable("productID") int pId, @PathVariable("userID") int uId) {
		if(orderService.buyProduct(pId, uId)){
			return "The product is ordered successfully";
		} else {
			return "Request denied!";}
	}
	
	@PatchMapping("/{id}/update/password")
	public String changePassword(@PathVariable("id") int id,@RequestParam String oldPassword,@RequestParam String newPassword)
	{
		if(userService.changePassword(id,oldPassword, newPassword))
		{
			return "Password changed successfully";
		}
		else
			return "Request Failed";
	}
	
	@PatchMapping("/{id}/update/name")
	public String changeName(@PathVariable("id") int id,@RequestParam String updatedName)
	{
		if(userService.changeName(id, updatedName))
		{
			return "Name changed successfully";
		}
		else
			return "Request Failed";
		
	}
	
	@DeleteMapping("/{userID}/delete/")
	public String deleteAccount(@PathVariable("userID") int userID)
	{
		userService.deleteUser(userID);
		return "Account deleted successfully.";
	}
	
}

