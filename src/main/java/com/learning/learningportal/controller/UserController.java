package com.learning.learningportal.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.entity.User;
import com.learning.learningportal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//ADMIN
	//GET
	//get all users 
	@GetMapping
	public List<User> getAllUsers(@RequestHeader Long user_Id) {
		Optional<User> adminUser = userService.loginUser(user_Id);

		if (adminUser.isPresent() && (adminUser.get().isAdmin())) {
			log.info("all users listed");
			return userService.seeAllUsers();
		}

		log.info("you are not authorized to retrive all users");
		return Collections.emptyList();
	}

	@GetMapping("/{id}")
	public Optional<User> enterUser(@RequestHeader Long user_Id, @PathVariable Long id) {
		Optional<User> adminUser = userService.loginUser(user_Id);

		if (adminUser.isPresent() && (adminUser.get().isAdmin())) {
			log.info("logged in");
			return userService.loginUser(id);
		}

		log.info("wrong credentials");
		return Optional.empty();
	}

	//DELETE
	@DeleteMapping("/{id}")
	public void removeUser(@RequestHeader Long user_Id, @PathVariable Long id) {
		Optional<User> adminUser = userService.loginUser(user_Id);

		if (adminUser.isPresent() && (adminUser.get().isAdmin())) {
			log.info("user deleted");
			userService.deleteUser(id);
		}
	}

	//LEARNER
	//get all courses
	@GetMapping("/purchased/{id}")
	public ResponseEntity<List<Course>> getAllCourses(@PathVariable Long id) {
		Optional<User> owningUser = userService.loginUser(id);

		if (owningUser.isPresent()) {
			List<Long> purchasedCourseIds = owningUser.get().getPurchasedCourses();
			List<Course> purchasedCourses = userService.seeAllCourses(purchasedCourseIds);
			log.info("showing all courses purchased");
			return ResponseEntity.ok(purchasedCourses);
		}

		log.info("error occured retriving the purchased courses");
		return ResponseEntity.notFound().build();
	}

	//POST
	@PostMapping
	public User addUser(@RequestBody User user) {
		//hashing password
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);

		log.info("user registered");
		return userService.registerUser(user);
	}

}
