package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Standard;
import net.javaguides.springboot.model.Subjects;

@Service
public class SubjectsService {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Subjects> getSubjectList() {


		Query query = new Query();
		List<Subjects> subjectsLIst = mongoTemplate.findAll(Subjects.class);
		return subjectsLIst;
	
		
		
	}
	

}
