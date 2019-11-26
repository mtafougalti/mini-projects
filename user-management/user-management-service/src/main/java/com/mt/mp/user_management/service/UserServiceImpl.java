package com.mt.mp.user_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.mp.user_management.dao.UserDao;
import com.mt.mp.user_management.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public List<User> getUsersByUserName(String name) {
		return userDao.getUsersByUserName(name);
	}

	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	public void deleteUser(Long id) {
		userDao.deleteUser(id);
	}

}
