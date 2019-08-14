package com.ardhi.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		//check student id
		if ( (studentId >= students.size() || (studentId < 0)) ) {
			throw new StudentNotFoundException("Student id not found - " +studentId);
		}
	
		return students.get(studentId);
	}
	
	
	// add Exception handler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
	}
}
























