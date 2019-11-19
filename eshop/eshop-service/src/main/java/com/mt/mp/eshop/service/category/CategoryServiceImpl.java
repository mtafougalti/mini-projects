package com.mt.mp.eshop.service.category;

import com.mt.mp.eshop.dao.category.CategoryDao;
import com.mt.mp.eshop.model.Category;
import com.mt.mp.eshop.service.generic.GenericServiceImpl;

public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {

	public CategoryServiceImpl(CategoryDao categoryDao) {
		super(categoryDao);
	}


}
