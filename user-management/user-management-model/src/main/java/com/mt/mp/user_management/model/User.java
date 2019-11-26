package com.mt.mp.user_management.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 2812914951709324679L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String password;
	private Date creationDate;
	
	public User(String userName, String password, Date creationDate) {
		this.userName = userName;
		this.password = password;
		this.creationDate = creationDate;
	}
	
	

}
