package com.sms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sms.model.Student;
import com.sms.repo.StudentRepository;

@RestController
@RequestMapping("api/student")
@CrossOrigin("*")
public class StudentController {
	
	private StudentRepository studentRepository;
	
	public StudentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	//Create New Student
	@PostMapping("CreateStudent")
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		try {
			studentRepository.save(student);
	        return new ResponseEntity<>("Object Inserted", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Object Insertion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
    }
	
	//Get all Department Details
	@GetMapping("GetAllStudent")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
	}

}
