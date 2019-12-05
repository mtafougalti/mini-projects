package com.mt.mp.eshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mt.mp.eshop.repositories.CategoryRepository;
import com.mt.mp.eshop.repositories.ProductRepository;

@SpringBootApplication
public class EshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository,
			CategoryRepository categoryRepository) {
		CommandLineRunner commandLineRunner = args -> {
			
		};
		return commandLineRunner;
	}

}
