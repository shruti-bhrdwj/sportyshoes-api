package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
