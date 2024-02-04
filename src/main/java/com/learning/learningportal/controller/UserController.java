package com.learning.learningportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learningportal.entity.User;
import com.learning.learningportal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//GET
	//get all users 

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.seeAllUsers();
	}

	@GetMapping("{uuid}")
	public Optional<User> enterUser(@PathVariable Long uuid) {
		return userService.loginUser(uuid);
	}

	//POST
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.registerUser(user);
	}

	//PUT
	//DELETE

}
