package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.models.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	

}
