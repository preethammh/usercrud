package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User insertedUser = userService.addUser(user);
		return new ResponseEntity<User>(insertedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId){
		User user= userService.findUserById(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User insertedUser = userService.addUser(user);
		return new ResponseEntity<User>(insertedUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("Dleted user with Id " + userId,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getUser/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
}
