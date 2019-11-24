package com.mt.mp.eshop.dao.client;

import javax.persistence.EntityManager;

import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.Client;

public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao{

	public ClientDaoImpl(EntityManager em) {
		super(em);
	}

}
