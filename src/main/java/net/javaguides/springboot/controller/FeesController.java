package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
import net.javaguides.springboot.model.Fees;

import net.javaguides.springboot.model.Standard;

import net.javaguides.springboot.repository.FeesRepository;
import net.javaguides.springboot.service.FeesService;
import net.javaguides.springboot.service.StandardService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FeesController {
	
	@Autowired
	private FeesService feesService;

//	@Autowired
//	private FeesRepository feesRepository;
	
	// get all employees
	@GetMapping("/Fees")
	public List<Fees> getAllFees(){
		List<Fees> feesList = feesService.getFeeList();
		return feesList;
	}		
	
	@GetMapping(value="/feesById")
	public Fees getFeesByID(String id)
	{
		
		Fees FeesbyID = feesService.getFeesByID(id);
		return FeesbyID;
	}
}
