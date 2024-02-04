package com.learning.learningportal.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long uuid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "isAdmin")
	private boolean isAdmin;

	@Column(name = "isAuthor")
	private boolean isAuthor;

	@Column(name = "purchasedCourses")
	private List<Long> purchasedCourses;

	//CONSTRUCTORS
	public User() {

	}

	public User(Long uuid, String username, String password, boolean isAdmin, boolean isAuthor,
			List<Long> purchasedCourses) {
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isAuthor = isAuthor;
		this.purchasedCourses = purchasedCourses;
	}

	//GETTERS AND SETTERS
	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isAuthor() {
		return isAuthor;
	}

	public void setAuthor(boolean isAuthor) {
		this.isAuthor = isAuthor;
	}

	public List<Long> getPurchasedCourses() {
		return purchasedCourses;
	}

	public void setPurchasedCourses(List<Long> purchasedCourses) {
		this.purchasedCourses = purchasedCourses;
	}
}
