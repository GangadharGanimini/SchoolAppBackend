package net.javaguides.springboot.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
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
	@Id
	
	private long _id;
	private String standardId;
	private String sectionId;
	private String name;
	private int standard;
	private int marks;

	
	
	
}
