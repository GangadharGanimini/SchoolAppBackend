package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Fees;
import net.javaguides.springboot.model.Standard;

@Service

public class FeesService {
	
	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Fees> getFeeList() {
		Query query = new Query();
		List<Fees> feesList = mongoTemplate.findAll(Fees.class);
		return feesList;
	}
	
    public Fees getFeesByID(String id) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Fees f = mongoTemplate.findById(query, Fees.class);
		return f;
		
	}

}
