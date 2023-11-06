package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.model.Standard;
import net.javaguides.springboot.model.Subjects;
import net.javaguides.springboot.service.SubjectsService;

public class SubjectsController {
	
	@Autowired
	private SubjectsService subjectsService;
	
	@GetMapping(value="/subjectsList")
	public List<Subjects> getsubjectssList()
	{
		List<Subjects> subjectsList = subjectsService.getSubjectList();
		return subjectsList;
	}

}
