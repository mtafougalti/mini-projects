package com.mt.mp.user_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mt.mp.user_management.model.User;
import com.mt.mp.user_management.service.UserService;

@RestController("/")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id")Long id) {
		return userService.getUser(id);
	}

	public User saveUser(User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users")
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
