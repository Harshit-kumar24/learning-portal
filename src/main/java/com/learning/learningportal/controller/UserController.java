package com.learning.learningportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.entity.User;
import com.learning.learningportal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//	ADMIN
	//GET
	//get all users 
	@GetMapping
	public List<User> getAllUsers() {
		return userService.seeAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<User> enterUser(@PathVariable Long id) {
		return userService.loginUser(id);
	}

	//LEARNER
	//get all courses
	@GetMapping("/purchased/{id}")
	public ResponseEntity<List<Course>> getAllCourses(@PathVariable Long id) {
		Optional<User> owningUser = userService.loginUser(id);

		if (owningUser.isPresent()) {
			List<Long> purchasedCourseIds = owningUser.get().getPurchasedCourses();
			List<Course> purchasedCourses = userService.seeAllCourses(purchasedCourseIds);
			return ResponseEntity.ok(purchasedCourses);
		}

		return ResponseEntity.notFound().build();
	}

	//POST
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.registerUser(user);
	}

	//DELETE
	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}
