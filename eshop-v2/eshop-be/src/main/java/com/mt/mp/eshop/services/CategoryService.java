package com.mt.mp.eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.mp.eshop.model.Category;
import com.mt.mp.eshop.repositories.CategoryRepository;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/add")
	public Category add(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	@GetMapping("/list")
	public List<Category> list(){
		return categoryRepository.findAll();
	}

}
