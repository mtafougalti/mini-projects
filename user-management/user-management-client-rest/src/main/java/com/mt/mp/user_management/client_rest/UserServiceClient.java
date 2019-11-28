package com.mt.mp.user_management.client_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("userServiceClient")
public class UserServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	private static final String BASE_URI = "http://localhost:8080/user-management-web";

	public List<? extends Object> getUsers() {
		return restTemplate.getForObject(BASE_URI + "/users", List.class);
	}

	public Object getUser(Long id) {
		return restTemplate.getForObject(BASE_URI + "/user/"+id, Object.class);
	}

	public Object saveUser(User user) {
		return restTemplate.postForObject(BASE_URI + "/addUser", user, User.class);
	}

	public List<? extends Object> getUsersByUserName(String name) {
		return restTemplate.getForObject(BASE_URI + "/users?name="+name, List.class);
	}

	public Object updateUser(User user) {
		 restTemplate.put(BASE_URI + "/updateUser", user);
		 return user;
	}

	public void deleteUser(Long id) {
		restTemplate.delete(BASE_URI + "/deleteUser/"+id);
	}

}
