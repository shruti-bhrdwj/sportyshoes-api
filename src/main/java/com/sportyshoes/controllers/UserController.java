package com.sportyshoes.controllers;


import java.util.List;

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
	
	@PostMapping("/signIn")
	public String userLogin(@RequestParam String name, @RequestParam String password) {
		if(userService.userAuth(name, password)){
			return "Logged in Successfully";
		} else 
			return "Login Failed";
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam String password)
	{
		User user= userService.addUser(name, password);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userID}")
	public User viweDetails(@PathVariable("userID") String id) {
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
	public String changePassword(@PathVariable("id") int id,@RequestParam String newPassword)
	{
		if(userService.changePassword(id, newPassword))
		{
			return "Password changed successfully";
		}
		else
			return "Request Failed";
	}
	
	@PatchMapping("/{id}/update/name")
	public String changeName(@PathVariable("id") int id,@RequestParam String newPassword)
	{
		if(userService.changeName(id, newPassword))
		{
			return "Name changed successfully";
		}
		else
			return "Request Failed";
		
	}
	
//	@PutMapping(path="/update/{userID}",
//			consumes = MediaType.APPLICATION_JSON_VALUE, 
//	        produces = MediaType.APPLICATION_JSON_VALUE)
//	public String updateUser(@PathVariable("userID") String id, @RequestBody User newUser)
//	{
//		userService.updateUser(id, newUser);
//		return "User updated successfully.";
//	}
	
//	@PostMapping(path = "/create", 
//	        consumes = MediaType.APPLICATION_JSON_VALUE, 
//	        produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<User> createUser(@RequestBody User newUser)
//	{
//		User user= userService.addUser(newUser);
//		return new ResponseEntity<>(user,HttpStatus.CREATED);
//	}
	
	
	@DeleteMapping("/{userID}/delete/")
	public String deleteAccount(@PathVariable("userID") int userID)
	{
		userService.deleteUser(userID);
		return "Account deleted successfully.";
	}
	
	@GetMapping("/")
	public List<User> getUserByName(@RequestParam String vendorName)
	{
		return userService.findUserByName(vendorName);
	}
	
}

