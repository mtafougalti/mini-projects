package com.mt.mp.user_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.mt.mp.user_management.service.UserService;

@Configuration
@Import(DaoConfig.class)
@ComponentScan(basePackages = { "com.mt.mp.user_management" })
public class ServiceConfig {

	@Bean
	public RmiServiceExporter rmiExporter(UserService userService) {
		RmiServiceExporter rmiExporter = new RmiServiceExporter();
		rmiExporter.setServiceInterface(UserService.class);
		rmiExporter.setService(userService);
		rmiExporter.setServiceName("UserService");
		rmiExporter.setRegistryPort(1099);
		return rmiExporter;
	}

}
