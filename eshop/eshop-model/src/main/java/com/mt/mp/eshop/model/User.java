package com.mt.mp.eshop.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = -9182896122702589348L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	private boolean active;
	@OneToMany
	@JoinColumn(name="id_user")
	private Collection<Role> roles;
}
