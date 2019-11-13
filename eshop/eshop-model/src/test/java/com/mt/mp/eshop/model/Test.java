package com.mt.mp.eshop.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		// Use persistence.xml configuration
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ESHOP_UNIT");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Role role = new Role();
		role.setName("ADMIN_ROLE");
		em.persist(role);
		em.getTransaction().commit();
		em.close();
		emf.close(); //close at application end
	}
}
