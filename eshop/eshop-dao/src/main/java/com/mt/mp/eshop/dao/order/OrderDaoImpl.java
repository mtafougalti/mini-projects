package com.mt.mp.eshop.dao.order;

import javax.persistence.EntityManager;

import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.Order;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao{

	public OrderDaoImpl(EntityManager em) {
		super(em);
	}

}
