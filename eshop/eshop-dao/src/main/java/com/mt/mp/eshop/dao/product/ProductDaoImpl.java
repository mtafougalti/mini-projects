package com.mt.mp.eshop.dao.product;

import javax.persistence.EntityManager;

import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.Product;

public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao{

	public ProductDaoImpl(EntityManager em) {
		super(em);
	}

}
