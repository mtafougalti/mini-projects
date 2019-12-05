package com.mt.mp.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderRow implements Serializable {
	
	private static final long serialVersionUID = 502348630037264646L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double price;
	private int quantity;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_order")
	private Order order;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_product")
	private Product product;
	
	public OrderRow(double price, int quantity) {
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
}
