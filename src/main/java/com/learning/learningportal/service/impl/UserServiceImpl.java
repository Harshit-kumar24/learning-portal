package com.learning.learningportal.service.impl;

import java.util.List;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.entity.User;
import com.learning.learningportal.repository.CourseRepository;
import com.learning.learningportal.repository.UserRepository;

public class UserServiceImpl {
	/*//ADMIN
		//SEE ALL USERS
		List<User> seeAllUsers();
	
		//SEE PURCHASED COURSES
		List<Course> seePurchsedCourses();
	
		//DELETE USERS
		void deleteUser(Course course);
	
		//LEARNER
		//LOGIN LEARNER
		User loginUser(User user);
	
		//REGISTER USER
		User registerUser(User user);*/

	private final UserRepository userRepository;
	private final CourseRepository courseRepository;

	public UserServiceImpl(UserRepository userRepository, CourseRepository courseRepository) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
	}

	//ADMIN
	//list all users
	public List<User> seeAllUsers() {
		return userRepository.findAll();
	}

	//delete user
	void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	//learner
	//list purchased courses
	public List<Course> seeAllCourses(List<Long> pids) {
		return courseRepository.findAllById(pids);
	}

}
