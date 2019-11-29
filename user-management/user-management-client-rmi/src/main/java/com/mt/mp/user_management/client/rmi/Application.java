package com.mt.mp.user_management.client.rmi;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mt.mp.user_management.model.User;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserServiceClient userServiceClient = ctx.getBean(UserServiceClient.class);
		List<User> users = userServiceClient.getUsers();
		users.forEach(e->{
			System.out.println(e);
		});
	}
	

}
