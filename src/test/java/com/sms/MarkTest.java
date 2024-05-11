package com.sms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sms.controller.MarkController;
import com.sms.model.Mark;
import com.sms.model.Student;
import com.sms.model.Subject;

@SpringBootTest
class MarkTest {
	
	@Autowired
	MarkController markController;	
	
	@Test
	void PerformInsertion(){
		Student stud=new Student();
		stud.setStudent_id(37); //Valid student Details
		
		Subject sub=new Subject();
		sub.setSubject_id(2); // Valid Subject Details
		
		Mark mark=new Mark();
		mark.setMark(96);
		mark.setStudent(stud);
		mark.setSubject(sub);
		
		ResponseEntity<?> result = markController.createMark(mark);
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
	

}
