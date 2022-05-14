package com.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	public boolean userAuth(String name, String pwd) {
			List<User> users = (List<User>) userRepository.findAll();
			for(User us : users)
			{
				if(us.getUname().equals(name) && us.getUserpwd().equals(pwd)) 
				{
					return true;
				}
			}
			return false;
		}
	

	public List<User> getAllUsers() {
	     return (List<User>) userRepository.findAll();
	}
	
	public User findUserById(String userid) {
		int id = Integer.parseInt(userid);
		return userRepository.findById(id).get();
	}
	
//	public User addUser(User user) {
//		return userRepository.save(user);
//	}
	
	public void updateUser(String userid,User user ) {
		int id = Integer.parseInt(userid);
		User us=userRepository.findById(id).get();
		if(us.getUserid()==id) userRepository.save(user);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}


	public User addUser(String name, String password) {
		User us = new User();
		us.setUname(name);
		us.setUserpwd(password);
		return userRepository.save(us);
	}
	
//	public void updateUser(int id, String name, String pwd) {
//		Optional<User> optional = userRepository.findById(id);
//		User usr = optional.get();
//		if(usr.getUserid()==id) {
//			usr.setUname(name);
//			usr.setUserpwd(pwd);
//		}else {
//			System.out.println("Invalid userID");
//		}
//	}
		
//	public User findUser(int userid) {
//	User user = new User();
//	User searchedUser = (User) userRepository.findAll();
//	if( searchedUser.getUserid() == userid)
//	{
//		user.getUname();
//		user.getUserid();
//		user.getUserpwd();
//	}
//	return user;
//	}

	
//	public User addUser(int userid, String name, String pwd) {
//		User usr = new User();
//		usr.setUname(name);
//		usr.setUserid(userid);
//		usr.setUserpwd(pwd);
//		return userRepository.save(usr);
//	}

//	public void updateUser(int id,String name, String pwd) {
//		Optional<User> optional = userRepository.findById(id);
//		User usr = optional.get();
//		if(usr.getUserid()==id && optional.isPresent()) {
//		  if() {
//			usr.setUname(name);
//			usr.setUserpwd(pwd);
//		}else {
//			System.out.println("Invalid userID");
//		}
//		
//	}

}
