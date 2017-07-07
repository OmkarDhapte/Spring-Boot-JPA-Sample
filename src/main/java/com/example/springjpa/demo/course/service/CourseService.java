package com.example.springjpa.demo.course.service;

import java.util.List;

public interface CourseService {

	public List<Course> getAllCourses();
	public Course getCourse(String courseName);
	public void addCourse(Course course);
	public void updateCourse(String id, Course course);
	public void deleteCourse(String id);
}
