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
@Document(collection="attendence")
public class Attendence {
	
	
	private String _id;
	private Boolean isPresent;
    private Date date;
    private String studentId;
    private String teacherId;
    
}
