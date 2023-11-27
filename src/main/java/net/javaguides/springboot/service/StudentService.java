package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Address;
import net.javaguides.springboot.model.Gender;
import net.javaguides.springboot.model.Student;

@Service
public class StudentService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	   @Autowired
	    public StudentService(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }

	public Student addStudent(Student student) {
		Student s = new Student();
		s.setFirstName(student.getFirstName());
		s.setMiddleName(student.getMiddleName());
		s.setLastName(student.getLastName());
		s.setDateOfBirth(student.getDateOfBirth());
		s.setBloodGroup(student.getBloodGroup());
		s.setPhoneNumber(student.getPhoneNumber());
		
		Address a = new Address();
		a.setCityName(student.getAddress().getCityName());
		a.setCountry(student.getAddress().getCountry());
		a.setPhoneNumber(student.getAddress().getPhoneNumber());
		a.setPinCode(student.getAddress().getPinCode());
		s.setAddress(a);
		
		Gender g = new Gender();
		g.setFemale(student.getGender().getFemale());
		g.setMale(student.getGender().getMale());
		g.setOther(student.getGender().getOther());
		s.setGender(g);
		
		mongoTemplate.save(s);

		
		
		return student;
		
		
	}

	public Student modifyStudent(Student updatedStudent,String studentId) {
		   // Create a query to find the student by _id
        Query query = new Query(Criteria.where("_id").is(studentId));


        // Create an update with the new values
        Update update = new Update()
                .set("standardId", updatedStudent.getStandardId())
                .set("sectionId", updatedStudent.getSectionId())
                .set("name", updatedStudent.getName())
                .set("standard", updatedStudent.getStandard())
                .set("marks", updatedStudent.getMarks())
                .set("firstName", updatedStudent.getFirstName())
                .set("middleName", updatedStudent.getMiddleName())
                .set("lastName", updatedStudent.getLastName())
                .set("dateOfBirth", updatedStudent.getDateOfBirth())
                .set("bloodGroup", updatedStudent.getBloodGroup())
                .set("phoneNumber", updatedStudent.getPhoneNumber())
                .set("address", updatedStudent.getAddress())
                .set("gender", updatedStudent.getGender());

        // Execute the update query
        mongoTemplate.updateFirst(query, update, Student.class);
    
		
		return updatedStudent;
	}

	public void deleteStudent(String studentId) {
		  // Create a query to find the teacher by _id
	    Query query = new Query(Criteria.where("_id").is(studentId));

	    // Execute the delete query
	    mongoTemplate.remove(query, Student.class);
		
	}

}
