package com.mt.mp.eshop.service.client;

import com.mt.mp.eshop.dao.client.ClientDao;
import com.mt.mp.eshop.model.Client;
import com.mt.mp.eshop.service.generic.GenericServiceImpl;

public class ClientServiceImpl extends GenericServiceImpl<Client> implements ClientService{

	public ClientServiceImpl(ClientDao clientDao) {
		super(clientDao);
	}


}
