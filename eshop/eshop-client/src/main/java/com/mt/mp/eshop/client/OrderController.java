package com.mt.mp.eshop.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mt.mp.eshop.model.Order;
import com.mt.mp.eshop.service.order.OrderService;

@Path("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController() {
		orderService = DependencyInjector.getInstance().getOrderService();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewOrder(Order order) {
		order.setDateOrder(new Date());
		orderService.createOrder(order);
		return "OK";
	}
	
	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getAllOrders(){
		return new ArrayList<Order>(orderService.findAll(Order.class));
	}
	
	@GET
	@Path("/{id}")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public Order getOrder(@PathParam("id") Long id){
		return orderService.findById(Order.class, id);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteOrder(@QueryParam("id") Long id) {
		System.out.println(id);
		Order order = orderService.findById(Order.class, id);
		orderService.delete(order);
		return "OK";
	}

}
