package com.learning.learningportal.service;

import java.util.List;
import java.util.Optional;

import com.learning.learningportal.entity.Course;

public interface CourseService {
	//GET ALL COURSES
	List<Course> getAllCourses();

	//GET UNIQUE COURSE
	Optional<Course> getCourse(Long id);

	//ADD A COURSE
	Course addCourse(Course course);

	//DELETE COURSES
	void deleteCourse(Long id);

	//UPDATE COURSES
	Course updateCourse(Course course);

}
