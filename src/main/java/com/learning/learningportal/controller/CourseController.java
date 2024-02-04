package com.learning.learningportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	//get all course
	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	//get a single course

	@GetMapping("{id}")
	public Optional<Course> getUniqueCourse(@PathVariable Long id) {
		return courseService.getCourse(id);
	}

	//post a course
	@PostMapping
	public Course postCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	//update course
	@PutMapping
	public Course updateCourse(Course course) {
		return courseService.updateCourse(course);
	}
	//delete course

	@DeleteMapping("{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}
}
