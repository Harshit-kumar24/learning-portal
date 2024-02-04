package com.learning.learningportal.service.impl;

import java.util.List;
import java.util.Optional;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.repository.CourseRepository;
import com.learning.learningportal.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	//GET ALL COURSES
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	//GET A SINGLE COURSE
	@Override
	public Optional<Course> getCourse(Long id) {
		return courseRepository.findById(id);
	}

	//ADD A COURSE
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	//UPDATING A COURSE
	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	//DELETE COURSE
	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}

}
