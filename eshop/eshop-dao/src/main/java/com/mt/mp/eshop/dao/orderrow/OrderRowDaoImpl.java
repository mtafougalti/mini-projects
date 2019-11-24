package com.mt.mp.eshop.dao.orderrow;

import javax.persistence.EntityManager;

import com.mt.mp.eshop.dao.generic.GenericDaoImpl;
import com.mt.mp.eshop.model.OrderRow;

public class OrderRowDaoImpl extends GenericDaoImpl<OrderRow> implements OrderRowDao{

	public OrderRowDaoImpl(EntityManager em) {
		super(em);
	}

}
