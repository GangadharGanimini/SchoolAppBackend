package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Address;
import net.javaguides.springboot.model.Gender;
import net.javaguides.springboot.model.Student;

@Service
public class StudentService {
	
	@Autowired
	MongoTemplate mongoTemplate;

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
		g.setMale(student.getGender().getFemale());
		g.setOther(student.getGender().getOther());
		s.setGender(g);
		
		mongoTemplate.save(s);

		
		
		return student;
		
		
	}

}
