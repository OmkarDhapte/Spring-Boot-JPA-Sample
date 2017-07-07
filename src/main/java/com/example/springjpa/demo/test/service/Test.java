package com.example.springjpa.demo.test.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.springjpa.demo.course.service.Course;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="test")
public class Test implements Serializable{

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty
	private String id;
	
	@NotNull
	private String testName;
	private String testDescription;
	
	@ManyToOne
	private Course course;
	
	public Test() {
		
	}
	
	public Test(String id, String testName, String testDescription,String courseId) {
		super();
		this.id = id;
		this.testName = testName;
		this.testDescription = testDescription;
		this.course = new Course(courseId, "", "");
	}
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
