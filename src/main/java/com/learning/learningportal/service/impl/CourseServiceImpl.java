package com.learning.learningportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learning.learningportal.entity.Course;
import com.learning.learningportal.repository.CourseRepository;
import com.learning.learningportal.service.CourseService;

@Service
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
	@SuppressWarnings("null")
	public Optional<Course> getCourse(Long id) {
		return courseRepository.findById(id);
	}

	//ADD A COURSE
	@Override
	@SuppressWarnings("null")
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	//UPDATING A COURSE
	@Override
	@SuppressWarnings("null")
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	//DELETE COURSE
	@Override
	@SuppressWarnings("null")
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}

}
