package com.mt.mp.user_management.client_rest;

import java.util.Date;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {
	
	private Long id;
	private String userName;
	private String password;
	private Date creationDate;

}
