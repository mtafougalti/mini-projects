package com.mt.mp.eshop.dao.role;

import javax.persistence.EntityManager;

import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.Role;

public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

	public RoleDaoImpl(EntityManager em) {
		super(em);
	}

}
