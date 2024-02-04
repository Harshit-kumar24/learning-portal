package com.learning.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.learningportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
