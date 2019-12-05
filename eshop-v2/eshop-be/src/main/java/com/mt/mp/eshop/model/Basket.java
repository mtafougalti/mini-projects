package com.mt.mp.eshop.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Basket implements Serializable {
	
	private static final long serialVersionUID = -9131291898325133205L;
	
	private Map<Long, OrderRow> items = new HashMap<Long, OrderRow>();

	public void addItem(Product product, int quantity) {
		if (items.get(product.getId()) != null) {
			OrderRow row = new OrderRow(product.getPrice(), quantity);
			row.setProduct(product);
			items.put(product.getId(), row);
		} else {
			OrderRow row = items.get(product.getId());
			row.setQuantity(row.getQuantity() + quantity);
		}
	}
	
	public void deleteItem(Long idProduct) {
		items.remove(idProduct);
	}
	
	public Collection<OrderRow> getAllItems() {
		return items.values();
	}
	
	public double getTotal() {
		double total = 0;
		for (OrderRow row : items.values()) {
			total += row.getPrice()*row.getQuantity();
		}
		return total;
	}
	
	public int getSize() {
		return items.size();
	}
	
}
