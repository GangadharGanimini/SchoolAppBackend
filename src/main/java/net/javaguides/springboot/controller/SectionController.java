package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.model.Section;
import net.javaguides.springboot.model.Standard;
import net.javaguides.springboot.service.SectionService;

@Controller


public class SectionController {
	
	@Autowired
	SectionService sectionService;
	
	@GetMapping(value="/sectionList")
	public List<Section> getSectionList()
	{
		List<Section> sectionList = sectionService.getSectionList();
		return sectionList;
	}
}
