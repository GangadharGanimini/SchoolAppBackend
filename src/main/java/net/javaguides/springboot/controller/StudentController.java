package net.javaguides.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Teacher;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.TeacherRepository;
import net.javaguides.springboot.service.StudentService;
import net.javaguides.springboot.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

//	@Autowired
//	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value ="/addStudent" )
	public Student addStudent(@RequestBody Student student) {
		Student addStudent = studentService.addStudent(student); 
		return addStudent;
		
	}
	
	
	
	// get all employees
//	@GetMapping("/Student")
//	public List<Student> getAllStudent(){
//		return studentRepository.findAll();
//	}		
//	
	
	


}
