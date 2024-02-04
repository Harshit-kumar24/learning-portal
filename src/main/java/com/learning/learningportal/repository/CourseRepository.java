package com.learning.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.learningportal.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
