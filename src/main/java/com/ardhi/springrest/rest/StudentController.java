package com.ardhi.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardhi.springrest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> students;
	
	// add post construct
	@PostConstruct
	public void loadStudent() {
		students = new ArrayList<>();
		
		students.add(new Student("Arya", "Wiguna"));
		students.add(new Student("Bintang", "Dilangit"));
		students.add(new Student("Cahyo", "Budiman"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		return students.get(studentId);
	}
	
}
