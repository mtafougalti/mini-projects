package com.mt.mp.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = -1169246748333953726L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@NotBlank
	@Size(min=5, max=50)
	private String description;
	private double price;
	private int quantity;
	private String photo;
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

}
