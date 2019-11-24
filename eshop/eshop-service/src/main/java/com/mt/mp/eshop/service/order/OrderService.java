package com.mt.mp.eshop.service.order;

import com.mt.mp.eshop.model.Order;
import com.mt.mp.eshop.service.generic.GenericService;

public interface OrderService extends GenericService<Order>{
	
	public void createOrder(Order order);
}
