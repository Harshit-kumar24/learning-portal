package com.learning.learningportal.service;

import java.util.List;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.entity.User;

public interface UserService {
	//ADMIN
	//SEE ALL USERS
	List<User> seeAllUsers();

	//SEE PURCHASED COURSES
	List<Course> seePurchsedCourses(List<Long> pids);

	//DELETE USERS
	void deleteUser(Course course);

	//LEARNER
	//LOGIN LEARNER
	User loginUser(User user);

	//REGISTER USER
	User registerUser(User user);
}
