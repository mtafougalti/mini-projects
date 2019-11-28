package com.mt.mp.user_management.client_rest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserServiceClient userServiceClient = (UserServiceClient) ctx.getBean("userServiceClient");
		
		List<? extends Object> list = userServiceClient.getUsers();
		list.forEach(e -> {
			System.out.println(e.toString());
		});
		System.out.println("------------------------------");
		Object user = userServiceClient.getUser(5L);
		System.out.println(user.toString());
		System.out.println("------------------------------");
		User usertoupdate = new User();
		usertoupdate.setId(10L);
		usertoupdate.setUserName("Fermon");
		usertoupdate.setPassword("coucou");
		Object user1 = userServiceClient.updateUser(usertoupdate);
		System.out.println(user1.toString());

	}
}
