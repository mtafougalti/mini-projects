package com.mt.mp.eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.mp.eshop.model.Product;
import com.mt.mp.eshop.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/add")
	public Product add(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/list")
	public List<Product> list(){
		return productRepository.findAll();
	}

}
