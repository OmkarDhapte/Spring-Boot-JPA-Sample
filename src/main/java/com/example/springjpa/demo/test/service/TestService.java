package com.example.springjpa.demo.test.service;

import java.util.List;

public interface TestService {

	public List<Test> getAllTests(String courseId);
	public Test getTest(String testName);
	public void addTest(Test test);
	public void updateTest(Test test);
	public void deleteTest(String id);
}
