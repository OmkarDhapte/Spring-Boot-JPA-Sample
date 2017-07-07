package com.example.springjpa.demo.test.controller;

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
import com.example.springjpa.demo.test.service.Test;
import com.example.springjpa.demo.test.service.TestService;


@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value= "/{courseId}/tests",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Test>> getAllTest(@PathVariable String courseId) {
		return ResponseEntity.ok().body(testService.getAllTests(courseId));
	}
	
	@RequestMapping(value= "/{courseId}/tests/{id}",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Test> getTest(@PathVariable String courseId,@PathVariable String id) {
		return ResponseEntity.ok().body(testService.getTest(id));
	}
	
	@RequestMapping(value= "/{courseId}/tests",method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Test> addTest(@PathVariable String courseId, @RequestBody Test test) {
		test.setCourse(new Course(courseId, "", ""));
		testService.addTest(test);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value= "/{courseId}/tests/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Test> deleteTest(@PathVariable String courseId, @PathVariable String id) {
		testService.deleteTest(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value= "{courseId}/tests/{id}",method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Test> updateTest(@PathVariable String courseId, @PathVariable String id,@RequestBody Test test) {
		test.setCourse(new Course(courseId, "", ""));
		testService.updateTest(test);
		return ResponseEntity.ok().build();
	}
}
