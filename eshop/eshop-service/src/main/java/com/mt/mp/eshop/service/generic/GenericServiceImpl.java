package com.mt.mp.eshop.service.generic;

import java.util.Collection;

import com.mt.mp.eshop.dao.generic.GenericDao;

public class GenericServiceImpl<T> implements GenericService<T> {
	
	protected GenericDao<T> genericDao;

	public GenericServiceImpl(GenericDao<T> genericDao) {
		this.genericDao = genericDao;
	}

	public void save(T entityObject) {
		genericDao.save(entityObject);
	}

	public void update(T entityObject) {
		genericDao.update(entityObject);
	}

	public void delete(T entityObject) {
		genericDao.delete(entityObject);
	}

	public T findById(Class<T> entityClass, Long id) {
		return genericDao.findById(entityClass, id);
	}

	public Collection<T> findAll(Class<T> entityClass) {
		return genericDao.findAll(entityClass);
	}

}
