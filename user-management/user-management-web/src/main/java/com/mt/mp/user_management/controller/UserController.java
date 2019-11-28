package com.mt.mp.user_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/addUser")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/usersByName")
	public List<User> getUsersByUserName(@RequestParam String name) {
		return userService.getUsersByUserName(name);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
}
