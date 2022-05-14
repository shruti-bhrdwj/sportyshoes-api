package com.sportyshoes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Product;
import com.sportyshoes.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	

	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
	public List<Product> findProductByName(String productName) {
		List<Product> list = (List<Product>) productRepository.findAll();
		List<Product> listByName = new ArrayList<Product>();
		for (Product p : list) {
			if(p.getPname().toLowerCase().contains(productName.toLowerCase())) {
				listByName.add(p);
			}
		}
		return listByName;
	}
	
	public List<Product> findProductByVendor(String VendorName) {
		List<Product> list = (List<Product>) productRepository.findAll();
		List<Product> listByVendor = new ArrayList<Product>();
		for (Product p : list) {
			if(p.getVendorInfo().toLowerCase().contains(VendorName.toLowerCase())) {
				listByVendor.add(p);
			}
		}
		return listByVendor;
	}
	
	public Product findProductById(int productId) {
		return productRepository.findById(productId).get();
	}

	public void deleteProduct(int pId) {
		productRepository.deleteById(pId);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(int pId,Product product ) {
		Product pr=productRepository.findById(pId).get();
		if(pr.getProductId()==pId) {
			productRepository.save(product);
		}else {
			System.out.println("Error: Invalid ProductID");
		}
		return product;
	}


}
