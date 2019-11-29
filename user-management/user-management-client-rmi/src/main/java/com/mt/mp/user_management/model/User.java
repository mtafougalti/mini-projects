package com.mt.mp.user_management.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = 2812914951709324679L;
	
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
