package com.example.springjpa.demo.test.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testRepository;
	
	/*private List<Test> tests = Arrays.asList(
			new Test("Java", "Java Test"),
			new Test("Spring", "Spring Test"),
			new Test("Android", "Android Test"));*/
		
	@Override
	public List<Test> getAllTests(String courseId) {
		//return tests;
		List<Test> tests = new LinkedList<>();
		testRepository.findByCourseId(courseId).forEach(tests::add);
		return tests;
	}

	@Override
	public void addTest(Test test) {
		testRepository.save(test);
	}
	
	@Override
	public Test getTest(String testName) {
		
		/** iterator 
		* 
		* new iterator introduce in java 8 
		* */	
		
		//return tests.stream().filter(t -> t.getTestName().toLowerCase().equals(testName.toLowerCase())).findFirst().get();
		return testRepository.findOne(testName);
	}

	@Override
	public void updateTest(Test test) {
		testRepository.save(test);
	}
	
	@Override
	public void deleteTest(String id) {
		testRepository.delete(id);
	}
}
