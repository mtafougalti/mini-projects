package com.mt.mp.eshop.dao.category;

import javax.persistence.EntityManager;

import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.Category;

public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao{

	public CategoryDaoImpl(EntityManager em) {
		super(em);
	}

}
