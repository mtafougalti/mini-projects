package com.mt.mp.eshop.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 910958807162196091L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String adress;
	private String email;
	private String phoneNumber;
	@OneToMany(mappedBy="client")
	private Collection<Order> orders;
}
