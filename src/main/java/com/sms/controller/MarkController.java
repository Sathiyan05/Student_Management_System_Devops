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

import com.sms.model.Mark;
import com.sms.repo.MarkRepository;

@RestController
@RequestMapping("api/mark")
@CrossOrigin("*")
public class MarkController {

	private MarkRepository markRepository;

	public MarkController(MarkRepository markRepository) {
		super();
		this.markRepository = markRepository;
	}

	// Create New Mark
	@PostMapping("CreateMark")
	public ResponseEntity<?> createMark(@RequestBody Mark mark) {
		try {
			markRepository.save(mark);
			return new ResponseEntity<>("Mark Saved to the Student", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Mark Not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	// Get all Marks
	@GetMapping("GetAllMarks")
	public ResponseEntity<List<Mark>> getAllMarks() {
		return new ResponseEntity<>(markRepository.findAll(), HttpStatus.OK);
	}


}
