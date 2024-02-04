package com.learning.learningportal.service;

import java.util.List;
import java.util.Optional;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.entity.User;

public interface UserService {

	//list a  users
	List<User> seeAllUsers();

	//list all purchased coursed
	List<Course> seeAllCourses(List<Long> pids);

	//delete user
	String deleteUser(Long id);

	//login user
	Optional<User> loginUser(Long id);

	//register user
	User registerUser(User user);

}
