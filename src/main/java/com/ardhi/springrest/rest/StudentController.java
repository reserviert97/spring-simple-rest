package com.ardhi.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardhi.springrest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Arya", "Wiguna"));
		students.add(new Student("Bintang", "Dilangit"));
		students.add(new Student("Cahyo", "Budiman"));
		
		return students;
	}
}
