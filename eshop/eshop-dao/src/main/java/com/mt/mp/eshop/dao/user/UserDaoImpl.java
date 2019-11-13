package com.mt.mp.eshop.dao.user;

import javax.persistence.EntityManager;

import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.User;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl(EntityManager em) {
		super(em);
	}

}
