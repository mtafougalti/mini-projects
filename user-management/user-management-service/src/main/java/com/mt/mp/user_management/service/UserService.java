package com.mt.mp.user_management.service;

import java.util.List;

import com.mt.mp.user_management.model.User;

public interface UserService {
	
	public User getUser(Long id);

	public User saveUser(User user);

	public List<User> getUsers();

	public List<User> getUsersByUserName(String name);
	
	public User updateUser(User user);
	
	public void deleteUser(Long id);

}
