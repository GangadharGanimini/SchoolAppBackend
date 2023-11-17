package net.javaguides.springboot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Address;
import net.javaguides.springboot.model.Gender;
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
  
	
	public Teacher addTeacher(Teacher teacher) {
		Teacher t = new Teacher();
		t.setFirstName(teacher.getFirstName());
		t.setMiddleName(teacher.getMiddleName());
		t.setLastName(teacher.getLastName());
		t.setDateOfBirth(teacher.getDateOfBirth());
		t.setBloodGroup(teacher.getBloodGroup());
		t.setPhoneNumber(teacher.getPhoneNumber());
		
		Address a = new Address();
		a.setCityName(teacher.getAddress().getCityName());
		a.setCountry(teacher.getAddress().getCountry());
		a.setPhoneNumber(teacher.getAddress().getPhoneNumber());
		a.setPinCode(teacher.getAddress().getPinCode());
		
	    t.setAddress(a);
		
		Gender g = new Gender();
		g.setFemale(teacher.getGender().getFemale());
		g.setMale(teacher.getGender().getFemale());
		g.setOther(teacher.getGender().getOther());
		
		t.setGender(g);
		
		mongoTemplate.save(t);

		
		
		return teacher;
		
	}

		public Teacher updateTeacher(Teacher updateTeacher,String teacherId) {
			   // Create a query to find the student by _id
	        Query query = new Query(Criteria.where("_id").is(teacherId));


	        // Create an update with the new values
	        Update update = new Update()
	                .set("standardId", updateTeacher.getStandardId())
	                .set("sectionId", updateTeacher.getSectionId())
	                .set("name", updateTeacher.getName())
	                .set("standard", updateTeacher.getStandard())
	                .set("marks", updateTeacher.getMarks())
	                .set("firstName", updateTeacher.getFirstName())
	                .set("middleName", updateTeacher.getMiddleName())
	                .set("lastName", updateTeacher.getLastName())
	                .set("dateOfBirth", updateTeacher.getDateOfBirth())
	                .set("bloodGroup", updateTeacher.getBloodGroup())
	                .set("phoneNumber", updateTeacher.getPhoneNumber())
	                .set("address", updateTeacher.getAddress())
	                .set("gender", updateTeacher.getGender());

	        // Execute the update query
	        mongoTemplate.updateFirst(query, update, Teacher.class);
	    
			
			return updateTeacher;
		}


		public void deleteTeacher(String teacherId) {
			  // Create a query to find the teacher by _id
		    Query query = new Query(Criteria.where("_id").is(teacherId));

		    // Execute the delete query
		    mongoTemplate.remove(query, Teacher.class);
			
		}
	


}
