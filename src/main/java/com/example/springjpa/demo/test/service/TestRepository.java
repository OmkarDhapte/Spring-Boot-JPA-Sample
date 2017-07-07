package com.example.springjpa.demo.test.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, String>{

	public List<Test> findByCourseId(String courseId);
}
