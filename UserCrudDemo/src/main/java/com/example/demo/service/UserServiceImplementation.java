package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserCrudException;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user) {

		// check if user object is empty
		if (user == null || user.isEmpty()) {
			throw new UserCrudException("User object cannot be null");
		}

		try {
			User insertedUser = userRepo.save(user);
			return insertedUser;
		} catch (DataIntegrityViolationException ex) {
			throw new UserCrudException("User already exists with given email addess");
		} catch (Exception ex) {
			throw new UserCrudException("User not added to the database, " + ex.getMessage());
		}
	}

	@Override
	public User findUserById(Long id) {
		try {
			Optional<User> user = userRepo.findById(id);
			return user.get();
		}
		catch(IllegalArgumentException ex) {
			throw new UserCrudException("Id cannot be null");
		}
		catch(Exception ex) {
			throw new UserCrudException("Cannot get the User object, " + ex.getMessage());
		}
	}

	@Override
	public void deleteUserById(Long id) {
		try {
			userRepo.deleteById(id);
		}
		catch(IllegalArgumentException ex) {
			throw new UserCrudException("Id cannot be null");
		}
		catch(Exception ex) {
			throw new UserCrudException("Unable to delete the User object, " + ex.getMessage());
		}

	}

	@Override
	public List<User> findAllUsers() {
		try {
			List<User> users = userRepo.findAll();
			return users;
		}
		catch(Exception ex) {
			throw new UserCrudException("Unable to get the User objects, " + ex.getMessage());
		}
	}

}
