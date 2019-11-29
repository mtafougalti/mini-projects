package com.mt.mp.user_management.service.test;

import java.rmi.RemoteException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mt.mp.user_management.config.ServiceConfig;
import com.mt.mp.user_management.model.User;
import com.mt.mp.user_management.service.UserService;

public class Application {

	public static void main(String[] args) throws RemoteException {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		userService.saveUser(new User("user3", "test1", new Date()));
		userService.saveUser(new User("user4", "azerty2", new Date()));
	}

}
