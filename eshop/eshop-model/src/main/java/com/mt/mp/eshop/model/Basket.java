package com.mt.mp.eshop.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Basket implements Serializable {
	
	private static final long serialVersionUID = -9131291898325133205L;
	
	private Map<Long, OrederRow> items = new HashMap<Long, OrederRow>();

	public void addItem(Product product, int quantity) {
		if (items.get(product.getId()) != null) {
			OrederRow row = new OrederRow(product.getPrice(), quantity);
			row.setProduct(product);
			items.put(product.getId(), row);
		} else {
			OrederRow row = items.get(product.getId());
			row.setQuantity(row.getQuantity() + quantity);
		}
	}
	
	public void deleteItem(Long idProduct) {
		items.remove(idProduct);
	}
	
	public Collection<OrederRow> getAllItems() {
		return items.values();
	}
	
	public double getTotal() {
		double total = 0;
		for (OrederRow row : items.values()) {
			total += row.getPrice()*row.getQuantity();
		}
		return total;
	}
	
	public int getSize() {
		return items.size();
	}
	
}
