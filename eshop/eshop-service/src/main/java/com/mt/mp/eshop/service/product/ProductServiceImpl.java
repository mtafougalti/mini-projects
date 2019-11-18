package com.mt.mp.eshop.service.product;

import com.mt.mp.eshop.dao.product.ProductDao;
import com.mt.mp.eshop.model.Product;
import com.mt.mp.eshop.service.generic.GenericServiceImpl;

public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService{

	public ProductServiceImpl(ProductDao productDao) {
		super(productDao);
	}


}
