package com.learning.learningportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.entity.User;
import com.learning.learningportal.repository.CourseRepository;
import com.learning.learningportal.repository.UserRepository;
import com.learning.learningportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final CourseRepository courseRepository;

	public UserServiceImpl(UserRepository userRepository, CourseRepository courseRepository) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
	}

	//ADMIN
	//list all users
	@Override
	public List<User> seeAllUsers() {
		return userRepository.findAll();
	}

	//delete user
	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "User deleted";
	}

	//LEARNER

	//login user
	@Override
	public Optional<User> loginUser(@Nullable Long uuid) {
		return userRepository.findById(uuid);
	}

	//list purchased courses
	@Override
	public List<Course> seeAllCourses(List<Long> pids) {
		return courseRepository.findAllById(pids);
	}

	//register user
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

}
