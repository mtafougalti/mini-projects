package com.mt.mp.eshop.service.generic;

import java.util.Collection;

public interface GenericService<T> {
	
	public void save(T entityObject);
	public void update(T entityObject);
	public void delete(T entityObject);
	public T findById(Class<T> entityClass, Long id);
	public Collection<T> findAll(Class<T> entityClass);

}
