package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Section;
import net.javaguides.springboot.model.Standard;

@Service
public class SectionService {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Section> getSectionList() {

		Query query = new Query();
		List<Section> sectionList = mongoTemplate.findAll(Section.class);
		return sectionList;
	}

}
