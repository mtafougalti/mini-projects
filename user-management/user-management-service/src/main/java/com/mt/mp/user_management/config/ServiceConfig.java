package com.mt.mp.user_management.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
@ComponentScan(basePackages={"com.mt.mp.user_management"})
public class ServiceConfig {
	
	
}
