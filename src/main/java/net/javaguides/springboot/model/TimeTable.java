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
@Document(collection="timetable")
public class TimeTable {
	
	private String _id;
	private String standardId;
	private Date timings;

}
