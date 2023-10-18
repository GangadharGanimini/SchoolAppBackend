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
import net.javaguides.springboot.model.Fees;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.FeesRepository;
import net.javaguides.springboot.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FeesController {

	@Autowired
	private FeesRepository feesRepository;
	
	// get all employees
	@GetMapping("/Fees")
	public List<Fees> getAllFees(){
		return feesRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/Fees")
	public Fees createFees(@RequestBody Fees fees) {
		return feesRepository.save(fees);
	}
	
	// get employee by id rest api
	@GetMapping("/Fees/{id}")
	public ResponseEntity<Fees> getFeesById(@PathVariable Long id) {
		Fees fees = feesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fees not exist with id :" + id));
		return ResponseEntity.ok(fees);
	}
	
	// update employee rest api
	
	@PutMapping("/Fees/{id}")
	public ResponseEntity<Fees> updateFees(@PathVariable Long id, @RequestBody Fees feesDetails){
		Fees fees = feesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fees not exist with id :" + id));
		
		fees.setName(feesDetails.getName());
		fees.setStandard(feesDetails.getStandard());
        fees.setFees(feesDetails.getFees());
	
        Fees updatedFees = feesRepository.save(fees);
		return ResponseEntity.ok(updatedFees);
	}
	
	// delete employee rest api
	@DeleteMapping("/Fees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Fees fees = feesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fees not exist with id :" + id));
		
		feesRepository.delete(fees);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
