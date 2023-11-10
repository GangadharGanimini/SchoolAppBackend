package net.javaguides.springboot.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="student")
public class Student {
	
	
	private long _id;
	private String standardId;
	private String sectionId;
	private String name;
	private int standard;
	private int marks;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String bloodGroup;
	private String phoneNumber;
	private Address address;
	private Gender gender;

	
	
	
}
