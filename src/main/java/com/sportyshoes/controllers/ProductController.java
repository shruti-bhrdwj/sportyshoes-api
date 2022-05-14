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

import com.sportyshoes.models.Product;
import com.sportyshoes.services.OrderService;
import com.sportyshoes.services.ProductService;

@RestController
@RequestMapping("/api/product/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/all")
	public List<Product> getProductList()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/name={productName}")
	public List<Product> getProductByName(@PathVariable("productName") String vendorName)
	{
		return productService.findProductByName(vendorName);
	}
	
	@GetMapping("/vendor={productName}")
	public List<Product> getProductByVendor(@PathVariable("productName") String productName)
	{
		return productService.findProductByName(productName);
	}
	
	//working
	@GetMapping("/pid={productId}")
	public Product productById(@PathVariable("productId") int productId)
	{
		return productService.findProductById(productId);
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId)
	{
		productService.deleteProduct(productId);
		return "Product deleted successfully.";
	}
	
	@PutMapping(path="/update/{productId}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") int pId, @RequestBody Product product)
	{
		productService.updateProduct(pId,product);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	//working
	@PostMapping(path="/add",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product pr= productService.addProduct(product);
		return new ResponseEntity<>(pr,HttpStatus.CREATED);
	}
	
	@PostMapping("/buy/")
	public String productPurchase(@RequestParam int pId, @RequestParam int uId) {
		if(orderService.buyProduct(pId, uId)){
			return "The product has been bought successfully";
		} else 
			return "Error: Request denied! Wrong productId or UserId";
	}
	
}
