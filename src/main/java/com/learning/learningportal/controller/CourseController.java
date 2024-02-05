package com.learning.learningportal.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.entity.User;
import com.learning.learningportal.service.CourseService;
import com.learning.learningportal.service.UserService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	private final CourseService courseService;
	private final UserService userService;
	private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	public CourseController(CourseService courseService, UserService userService) {
		this.courseService = courseService;
		this.userService = userService;
	}

	//get all course
	@GetMapping
	public List<Course> getAllCourses(@RequestBody User user) {
		if (user.isAuthor()) {
			log.info("Showing all courses");
			return courseService.getAllCourses();
		}
		log.info("you are not authorized to see all courses");
		return Collections.emptyList();
	}
	//get a single course

	@GetMapping("{id}")
	public Optional<Course> getUniqueCourse(@RequestHeader Long user_id, @PathVariable Long id) {
		Optional<User> authorUser = userService.loginUser(user_id);

		if (authorUser.isPresent() && (authorUser.get().isAuthor())) {
			log.info("Showing the course");
			return courseService.getCourse(id);
		}

		log.info("Error occured not able to show the course");
		return Optional.empty();
	}

	//post a course
	@PostMapping
	public Course postCourse(@RequestHeader Long user_id, @RequestBody Course course) {
		Optional<User> authorUser = userService.loginUser(user_id);

		if (authorUser.isPresent() && (authorUser.get().isAuthor())) {
			log.info("course added");
			return courseService.addCourse(course);
		}
		Course unAuthorizedCourse = new Course();
		unAuthorizedCourse.setUuid(-1L);
		log.info("you are not authorized to post a course");
		return unAuthorizedCourse;
	}

	//update course
	@PutMapping
	public Course updateCourse(@RequestHeader Long id, @RequestBody Course course) {
		Optional<User> authorUser = userService.loginUser(id);

		if (authorUser.isPresent() && (authorUser.get().isAuthor())) {
			log.info("course updated");
			return courseService.updateCourse(course);

		}

		Course unAuthorizedCourse = new Course();
		unAuthorizedCourse.setUuid(-1L);
		log.info("you not authorized to update a course");
		return unAuthorizedCourse;
	}

	//delete course
	@DeleteMapping("{id}")
	public void deleteCourse(@RequestHeader Long user_id, @PathVariable Long id) {
		Optional<User> authorUser = userService.loginUser(user_id);

		if (authorUser.isPresent() && (authorUser.get().isAuthor())) {
			log.info("course deleted");
			courseService.deleteCourse(id);
		}
		log.info("you are not authorized to delete a course");
	}
}
