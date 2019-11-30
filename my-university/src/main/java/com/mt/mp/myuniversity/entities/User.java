package com.mt.mp.myuniversity.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = -4626343067637984440L;
	
	@Id
	private String username;
	private String password;
	private boolean active;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="User_Role")
	private Collection<Role> roles;
	
	public User(String username, String password, boolean active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}
	
	
}
