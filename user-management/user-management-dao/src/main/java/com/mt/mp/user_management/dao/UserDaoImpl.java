package com.mt.mp.user_management.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mt.mp.user_management.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public User getUser(Long id) {
		return em.find(User.class, id);
	}

	@Transactional
	public User saveUser(User user) {
		em.persist(user);
		return user;
	}

	@Transactional
	public List<User> getUsers() {
		return new ArrayList<User>(em.createQuery("from User", User.class).getResultList());
	}

	@Transactional
	public List<User> getUsersByUserName(String name) {
		Query query = em.createQuery("select u from User u where u.userName like :name", User.class);
		query.setParameter("name", "%" + name + "%");
		return new ArrayList<User>(query.getResultList());
	}

	@Transactional
	public User updateUser(User user) {
		em.merge(user);
		return user;
	}

	@Transactional
	public void deleteUser(Long id) {
		em.remove(getUser(id));
	}

}
