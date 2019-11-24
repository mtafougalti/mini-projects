package com.mt.mp.eshop.service.order;

import com.mt.mp.eshop.dao.order.OrderDao;
import com.mt.mp.eshop.dao.orderrow.OrderRowDao;
import com.mt.mp.eshop.model.Order;
import com.mt.mp.eshop.model.OrderRow;
import com.mt.mp.eshop.service.generic.GenericServiceImpl;

public class OrderServiceImpl extends GenericServiceImpl<Order> implements OrderService{
	
	private OrderRowDao orderRowDao;

	public OrderServiceImpl(OrderDao orderDao) {
		super(orderDao);
	}
	
	public OrderServiceImpl(OrderDao orderDao, OrderRowDao orderRowDao) {
		super(orderDao);
		this.orderRowDao = orderRowDao;
	}

	@Override
	public void createOrder(Order order) {
		genericDao.save(order);
		if(order.getItems()!=null && !order.getItems().isEmpty()) {
			for (OrderRow item : order.getItems()) {
				item.setOrder(order);
				orderRowDao.save(item);
			}
		}
	}

	

}
