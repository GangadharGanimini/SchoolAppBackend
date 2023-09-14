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
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	// get all employees
	@GetMapping("/Student")
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/Student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	// get employee by id rest api
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(student);
	}
	
	// update employee rest api
	
	@PutMapping("/Student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
		
		student.setName(studentDetails.getName());
		student.setClassNumber(studentDetails.getClassNumber());
		student.setMarks(studentDetails.getMarks());
		
		Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	// delete employee rest api
	@DeleteMapping("/Student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


}
