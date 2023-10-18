package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Standard;

@Service
public class StandardService {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Standard> getStandardList() {

		Query query = new Query();
		List<Standard> standardList = mongoTemplate.findAll(Standard.class);
		return standardList;
	}

	
}
