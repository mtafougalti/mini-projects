package com.mt.mp.myuniversity.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Role implements Serializable{
	
	private static final long serialVersionUID = 6436862055427754166L;
	
	@Id
	private String name;
	private String description;
	
	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	

}
