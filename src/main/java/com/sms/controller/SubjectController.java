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

import com.sms.model.Subject;
import com.sms.repo.SubjectRepository;

@RestController
@RequestMapping("api/subject")
@CrossOrigin("*")
public class SubjectController {

	private SubjectRepository subjectRepository;

	public SubjectController(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}

	// Create New Subject
	@PostMapping("CreateSubject")
	public ResponseEntity<?> createSubject(@RequestBody Subject subject) {
		try {
			subjectRepository.save(subject);
			return new ResponseEntity<>("Mark Saved to the Student", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Mark Not saved", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

	// Get all subjects
	@GetMapping("GetAllSubjects")
	public ResponseEntity<List<Subject>> getAllSubject() {
		return new ResponseEntity<>(subjectRepository.findAll(), HttpStatus.OK);
	}


}
