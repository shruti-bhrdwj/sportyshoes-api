package com.sportyshoes.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.User;
import com.sportyshoes.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String userLogin(@RequestParam String name, @RequestParam String password)
	{
		if(userService.userAuth(name, password)){
			return "Logged in Successfully";
		} else 
			return "Login Failed";
	}
	
	//working
	@GetMapping("/all")
	public List<User> getUsers()
	{
		return userService.getAllUsers();
	}
	
	//working
	@GetMapping("/id={userID}")
	public User getUser(@PathVariable("userID") String id) {
		return userService.findUserById(id);
	}
	
	//working
	@DeleteMapping("/delete/{userID}")
	public String deleteUser(@PathVariable("userID") int userID)
	{
		userService.deleteUser(userID);
		return "User deleted successfully.";
	}
	
	@PutMapping(path="/update/{userID}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@PathVariable("userID") String id, @RequestBody User newUser)
	{
		userService.updateUser(id, newUser);
		return "User updated successfully.";
	}
	
	
//	@PostMapping(path = "/create", 
//	        consumes = MediaType.APPLICATION_JSON_VALUE, 
//	        produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<User> createUser(@RequestBody User newUser)
//	{
//		User user= userService.addUser(newUser);
//		return new ResponseEntity<>(user,HttpStatus.CREATED);
//	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam String password)
	{
		User user= userService.addUser(name, password);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
}

