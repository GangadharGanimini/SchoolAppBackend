package net.javaguides.springboot.model;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="fees")
public class Fees {
	
	
	private long _id;
	private String name;
	private int standard;
	private int fees;

	
	

}
