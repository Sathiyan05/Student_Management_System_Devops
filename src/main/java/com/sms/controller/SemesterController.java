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

import com.sms.model.Semester;
import com.sms.repo.SemesterRepository;

@RestController
@RequestMapping("api/semester")
@CrossOrigin("*")
public class SemesterController {

	private SemesterRepository semesterRepository;

	public SemesterController(SemesterRepository semesterRepository) {
		super();
		this.semesterRepository = semesterRepository;
	}

	// Create New Semester
	@PostMapping("CreateSemester")
	public ResponseEntity<?> createSemester(@RequestBody Semester semester) {
		try {
			semesterRepository.save(semester);
			return new ResponseEntity<>("Mark Saved to the Student", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Mark Not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get all Semester Details
	@GetMapping("GetAllSemesters")
	public ResponseEntity<List<Semester>> getAllSemesters() {
		return new ResponseEntity<>(semesterRepository.findAll(), HttpStatus.OK);
	}


}
