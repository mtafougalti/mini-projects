package com.mt.mp.eshop.dao.generic;

import java.util.Collection;

import javax.persistence.EntityManager;

public class GenericDaoImpl<T> implements GenericDao<T>{
	
	protected EntityManager em;
	
	

	public GenericDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void save(T entityObject) {
		em.getTransaction().begin();
		em.persist(entityObject);
		em.getTransaction().commit();
	}

	public void update(T entityObject) {
		em.getTransaction().begin();
		em.merge(entityObject);
		em.getTransaction().commit();
	}

	public void delete(T entityObject) {
		em.getTransaction().begin();
		em.remove(entityObject);
		em.getTransaction().commit();
	}

	public T findById(Class<T> entityClass, Long id) {
		return em.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAll(Class<T> entityClass) {
		return em.createQuery("from " + entityClass.getName()).getResultList();
	}

}
