package com.example.springjpa.demo.course.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	/*private List<course> courses = Arrays.asList(
			new course("Java", "Java course"),
			new course("Spring", "Spring course"),
			new course("Android", "Android course"));*/
		
	@Override
	public List<Course> getAllCourses() {
		//return courses;
		List<Course> courses = new LinkedList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	@Override
	public Course getCourse(String courseName) {
		
		/** iterator 
		* 
		* new iterator introduce in java 8 
		* */	
		
		//return courses.stream().filter(t -> t.getcourseName().toLowerCase().equals(courseName.toLowerCase())).findFirst().get();
		return courseRepository.findOne(courseName);
	}

	@Override
	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
	}
	
	@Override
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
