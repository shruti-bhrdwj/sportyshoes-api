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
	
	public String getAllUsers() {
	     return userRepository.findAll().toString();
	}
	
	public String findUserById(String userid) {
		int id = Integer.parseInt(userid);
		return userRepository.findById(id).get().toString();
	}

	public User addUser(String name, String password) {
		User us = new User();
		us.setUname(name);
		us.setUserpwd(password);
		return userRepository.save(us);
	}


	public boolean changePassword(int id,String oldPassword, String newPassword) {
		User us = userRepository.findById(id).get();
		if (us.getUserpwd().equals(oldPassword)){
			us.setUserpwd(newPassword);
			userRepository.save(us);
		}
		if(us.getUserpwd().equals(newPassword)) {
			return true;
		}else return false;
	}


	public boolean changeName(int id, String name) {
		User us = userRepository.findById(id).get();
		us.setUname(name);
		userRepository.save(us);
		
		if(us.getUname().equals(name))return true;
		else return false;
	}
	
	public String findUserByName(String uname) {
		Iterable<User> list = userRepository.findAll();
		ArrayList<User> listByName = new ArrayList<>();
		for (User us : list) {
			if(us.getUname().toLowerCase().contains(uname.toLowerCase())) {
				listByName.add(us);
			}
		}
		return listByName.toString();
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
