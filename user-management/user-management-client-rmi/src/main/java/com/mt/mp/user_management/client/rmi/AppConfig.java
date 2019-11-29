package com.mt.mp.user_management.client.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
@ComponentScan(basePackages= {"com.mt.mp.*"})
public class AppConfig {
	
	@Bean
	public RmiProxyFactoryBean rmiProxyFactory() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl("rmi://localhost:1099/UserService");
		rmiProxyFactory.setServiceInterface(UserService.class);
		return rmiProxyFactory;
	}

}
