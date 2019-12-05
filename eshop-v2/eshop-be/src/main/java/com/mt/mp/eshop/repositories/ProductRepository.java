package com.mt.mp.eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.mp.eshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
