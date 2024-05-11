package com.sms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Department;
import com.sms.repo.DepartmentRepository;


@RestController
@RequestMapping("api/department")
@CrossOrigin("*")
public class DepartmentController {

	private DepartmentRepository departmentRepository;

	public DepartmentController(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	
	//Create New Department
	@PostMapping("CreateDepartment")
	public ResponseEntity<?> createDepartment(@RequestBody Department department) {
		try {
			departmentRepository.save(department);
			return new ResponseEntity<>("Mark Saved to the Student", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Mark Not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	//Get all Department Details
	@GetMapping("GetAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		return new ResponseEntity<>(departmentRepository.findAll(), HttpStatus.OK);
	}


	
}
