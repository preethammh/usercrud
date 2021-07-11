package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

	public User addUser(User user);
	
	public User findUserById(Long id);
	
	public void deleteUserById(Long id);
	
	public List<User> findAllUsers();
}
