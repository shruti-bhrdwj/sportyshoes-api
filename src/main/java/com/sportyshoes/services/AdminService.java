package com.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Admin;
import com.sportyshoes.repositories.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository admRepository;
	
	public boolean adminAuth(String name, String pwd) {
		List<Admin> admins = (List<Admin>) admRepository.findAll();
		for(Admin ad : admins)
		{
			if(ad.getAdminName().equals(name) && ad.getAdminPwd().equals(pwd)) 
			{
				return true;
			}
		}
		return false;
		
	}
	
	public Admin getAdminDetails(int Id) {
		return admRepository.findById(Id).get();
	}
	
	public boolean changePassword(int id, String newPassword)
	{
		Admin admin = admRepository.findById(id).get();
		admin.setAdminPwd(newPassword);
		admRepository.save(admin);
		
		if(admRepository.findById(id).get().getAdminPwd().equals(newPassword)) {
			return true;
		}else return false;
	}
}
