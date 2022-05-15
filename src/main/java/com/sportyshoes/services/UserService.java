package com.sportyshoes.services;

import java.util.ArrayList;
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
			for(User us : users) {
				if(us.getUname().equals(name) && us.getUserpwd().equals(pwd)) {
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
	
//	public void updateUser(String userid,User user ) {
//		int id = Integer.parseInt(userid);
//		User us=userRepository.findById(id).get();
//		if(us.getUserid()==id) userRepository.save(user);
//	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}


	public User addUser(String name, String password) {
		User us = new User();
		us.setUname(name);
		us.setUserpwd(password);
		return userRepository.save(us);
	}


	public boolean changePassword(int id, String newPassword) {
		User us = userRepository.findById(id).get();
		us.setUserpwd(newPassword);
		userRepository.save(us);
		
		if(userRepository.findById(id).get().getUserpwd().equals(newPassword)) {
			return true;
		}else return false;
	}


	public boolean changeName(int id, String name) {
		User us = userRepository.findById(id).get();
		us.setUname(name);
		userRepository.save(us);
		
		if(userRepository.findById(id).get().getUname().equals(name)) {
			return true;
		}else return false;
	}

	public List<User> findUserByName(String uname) {
		List<User> list = (List<User>) userRepository.findAll();
		List<User> listByName = new ArrayList<>();
		for (User us : list) {
			if(us.getUname().toLowerCase().contains(uname.toLowerCase())) {
				listByName.add(us);
			}
		}
		return listByName;
	}	

}
