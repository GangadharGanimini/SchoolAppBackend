package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import net.javaguides.springboot.model.Standard;
import net.javaguides.springboot.model.Teacher;
import net.javaguides.springboot.repository.TeacherRepository;
import net.javaguides.springboot.service.StandardService;
import net.javaguides.springboot.service.TeacherService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TeacherController {

//	@Autowired
//	private TeacherRepository teacherRepository;
	
	@Autowired
	private TeacherService teacherService;
	
	// get all employees
	@GetMapping("/teacher")
	public List<Teacher> getAllTeacher(){

		List<Teacher> teacherList = teacherService.getTeacherList();
		return teacherList;
		}		
	
	@PutMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher,String teacherId)
	{
		Teacher updateTeacher = teacherService.updateTeacher(teacher,teacherId);
		return updateTeacher;
	}
	

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable String teacherId) {
        try {
            teacherService.deleteTeacher(teacherId);
            return new ResponseEntity<>("Teacher deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions, e.g., teacher not found
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	// create employee rest api
//	@PostMapping("/teacher")
//	public Teacher createEmployee(@RequestBody Teacher employee) {
//		return teacherRepository.save(employee);
//	}
	
	// get employee by id rest api
//	@GetMapping("/teacher/{id}")
//	public ResponseEntity<Teacher> getEmployeeById(@PathVariable Long id) {
//		Teacher employee = teacherRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		return ResponseEntity.ok(employee);
//	}
	
	// update employee rest api
	
//	@PutMapping("/teacher/{id}")
//	public ResponseEntity<Teacher> updateEmployee(@PathVariable Long id, @RequestBody Teacher employeeDetails){
//		Teacher employee = teacherRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Teacher updatedEmployee = teacherRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	
	// delete employee rest api
//	@DeleteMapping("/teacher/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//		Teacher employee = teacherRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		teacherRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	
	
}
