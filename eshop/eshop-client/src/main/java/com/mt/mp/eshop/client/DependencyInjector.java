package com.mt.mp.eshop.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mt.mp.eshop.dao.generic.GenericDao;
import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.Role;
import com.mt.mp.eshop.service.generic.GenericService;
import com.mt.mp.eshop.service.generic.GenericServiceImpl;

import lombok.Getter;

@Getter
public class DependencyInjector {
	
	private static final DependencyInjector INSTANCE = new DependencyInjector();
	
	private GenericService<Role> roleService;
	
	private DependencyInjector() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ESHOP_UNIT");
		EntityManager em = emf.createEntityManager();
		
		//Inject ROLE dependencies
		GenericDao<Role> roleDao = new GenericDaoImpl<Role>(em);
		roleService = new GenericServiceImpl<Role>(roleDao);
	}
	
	public static DependencyInjector getInstance() {
		return INSTANCE;
	}

}
