package com.mt.mp.myuniversity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.mp.myuniversity.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByUsername(String userName);

}
