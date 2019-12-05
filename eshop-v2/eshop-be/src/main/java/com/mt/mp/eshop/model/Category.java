package com.mt.mp.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Category implements Serializable{
	
	private static final long serialVersionUID = -3581725228792023614L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String photo;
	
	public Category(String name, String description, String photo) {
		this.name = name;
		this.description = description;
		this.photo = photo;
	}
	
	

}
