package com.mt.mp.eshop.service.role;

import com.mt.mp.eshop.dao.role.RoleDao;
import com.mt.mp.eshop.model.Role;
import com.mt.mp.eshop.service.generic.GenericServiceImpl;

public class RoleServiceImpl extends GenericServiceImpl<Role> implements RoleService {

	public RoleServiceImpl(RoleDao roleDao) {
		super(roleDao);
	}

}
