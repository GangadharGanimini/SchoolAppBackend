package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.model.Standard;
import net.javaguides.springboot.service.StandardService;

@Controller
public class StandardController {
  
	@Autowired
	private StandardService standardService;
	
	@GetMapping(value="/standardList")
	public List<Standard> getStandardList()
	{
		List<Standard> standardList = standardService.getStandardList();
		return standardList;
	}
	
	
	@GetMapping(value="/standardById")
	public Standard getStandardByID(String id,String name)
	{
		
		Standard studentbyID = standardService.getStandardByID(id,name);
		return studentbyID;
		
	}
	
	
}
