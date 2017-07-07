package com.example.springjpa.demo.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.demo.course.service.Course;
import com.example.springjpa.demo.course.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value= "/getAllCourse",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Course>> getAllCourse() {
		return ResponseEntity.ok().body(courseService.getAllCourses());
	}
	
	@RequestMapping(value= "/getCourse/{courseName}",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Course> getCourse(@PathVariable String courseName) {
		return ResponseEntity.ok().body(courseService.getCourse(courseName));
	}
	
	@RequestMapping(value= "/addCourse",method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Course> addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value= "/deleteCourse/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Course> deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value= "/updateCourse/{id}",method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Course> updateCourse(@PathVariable String id,@RequestBody Course course) {
		courseService.updateCourse(id, course);
		return ResponseEntity.ok().build();
	}
}
