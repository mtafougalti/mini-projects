package com.mt.mp.user_management.client.rmi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mt.mp.user_management.model.User;

@Component
public class UserServiceClient {
	
	@Autowired
	private UserService userService;

	public User getUser(Long id) {
		return userService.getUser(id);
	}

	public User saveUser(User user) {
		return userService.saveUser(user);
	}

	public List<User> getUsers() {
		return userService.getUsers();
	}

	public List<User> getUsersByUserName(String name) {
		return userService.getUsersByUserName(name);
	}

	public User updateUser(User user) {
		return userService.updateUser(user);
	}

	public void deleteUser(Long id) {
		userService.deleteUser(id);
	}
	
	

}
