package com.mt.mp.eshop.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Order implements Serializable {
	
	private static final long serialVersionUID = -2862824277435779077L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateOrder;
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	@OneToMany(mappedBy="order")
	private Collection<OrederRow> items;
	
}
