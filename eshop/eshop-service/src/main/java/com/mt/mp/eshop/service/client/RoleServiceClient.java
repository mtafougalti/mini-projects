package com.mt.mp.eshop.service.client;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mt.mp.eshop.dao.generic.GenericDao;
import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.Role;
import com.mt.mp.eshop.service.generic.GenericService;
import com.mt.mp.eshop.service.generic.GenericServiceImpl;

public class RoleServiceClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ESHOP_UNIT");
		EntityManager em = emf.createEntityManager();
		
		GenericDao<Role> roleDao = new GenericDaoImpl<Role>(em);
		GenericService<Role> roleService = new GenericServiceImpl<Role>(roleDao);
		
		Collection<Role> allRoles = getAllRoles(roleService);
		for (Role r : allRoles) {
			System.out.println(r.getName());
		}
	}

	private static Collection<Role> getAllRoles(GenericService<Role> roleService) {
		return roleService.findAll(Role.class);
	}

}
