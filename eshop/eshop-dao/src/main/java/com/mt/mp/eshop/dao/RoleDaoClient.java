package com.mt.mp.eshop.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mt.mp.eshop.dao.generic.GenericDao;
import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.dao.role.RoleDao;
import com.mt.mp.eshop.dao.role.RoleDaoImpl;
import com.mt.mp.eshop.model.Role;

public class RoleDaoClient {
	public static void main(String[] args) {
		// Use persistence.xml configuration
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ESHOP_UNIT");
		EntityManager em = emf.createEntityManager();
		//RoleDao roleDao = new RoleDaoImpl(em);
		GenericDao<Role> roleDao = new GenericDaoImpl<Role>(em);
		// addRole(roleDao);
		Role role = getRoleById(roleDao, 3L);
		System.out.println("Role Name : " + role.getName());
		//deleteRole(roleDao, 2L);
		Collection<Role> allRoles = getAllRoles(roleDao);
		for (Role r : allRoles) {
			System.out.println(r.getName());
		}
		em.close();
		emf.close(); // close at application end
	}

	private static void addRole(RoleDao roleDao) {
		Role role = new Role();
		role.setName("CLIENT_ROLE");
		roleDao.save(role);
	}

	private static Role getRoleById(GenericDao<Role> roleDao, Long id) {
		return roleDao.findById(Role.class, id);
	}

	private static void deleteRole(RoleDao roleDao, Long id) {
		Role role = roleDao.findById(Role.class, id);
		roleDao.delete(role);
	}
	
	private static Collection<Role> getAllRoles(GenericDao<Role> roleDao) {
		return roleDao.findAll(Role.class);
	}

}
