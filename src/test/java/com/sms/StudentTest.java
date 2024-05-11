package com.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sms.controller.StudentController;
import com.sms.model.Department;
import com.sms.model.Student;

@SpringBootTest
public class StudentTest {

	@Autowired
	private StudentController studentController;

	@Test
	void testInsertStudent() throws Exception {
		Department department = new Department();
		department.setDepartment_id(1); // Valid department ID

		Student student = new Student();
		student.setName("Sandy");
		student.setEmail("sandy@gmail.com");
		student.setContact("9874563210");
		student.setLocation("Andhra");
		student.setDepartment(department);

		ResponseEntity<?> result = studentController.createStudent(student);
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
}