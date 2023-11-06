package net.javaguides.springboot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Section;
import net.javaguides.springboot.model.Standard;
import net.javaguides.springboot.model.Teacher;

@Service
public class TeacherService {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Teacher> getTeacherList() {

		Query query = new Query();
		List<Teacher> teacherList = mongoTemplate.findAll(Teacher.class);
		return teacherList;
	}


}
