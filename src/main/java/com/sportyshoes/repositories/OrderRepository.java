package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.models.Orders;																																								

public interface OrderRepository extends CrudRepository<Orders,Integer>{
	

}
