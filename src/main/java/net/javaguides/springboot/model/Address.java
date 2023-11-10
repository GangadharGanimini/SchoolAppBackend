package net.javaguides.springboot.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String country;
	private String cityName;
	private Date pinCode;
	private String phoneNumber;
}
