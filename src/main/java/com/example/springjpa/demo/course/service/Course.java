package com.example.springjpa.demo.course.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="course")
public class Course implements Serializable{

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty
	private String id;
	
	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	public Course() {
		
	}
	
	public Course(String id, String courseName, String courseDescription) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}
	
	public String getcourseName() {
		return courseName;
	}
	public void setcourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getcourseDescription() {
		return courseDescription;
	}
	public void setcourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	
}
