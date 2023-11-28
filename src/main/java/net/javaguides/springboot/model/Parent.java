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
@Document(collection = "parent_details")
public class Parent {

    private String id;
    private String name;
    private String firstName;
    private String middleName;
    private String lastName;
	private Date dateOfBirth;
    public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	private long phoneNumber;
    private long phoneNumber2;
    private String email;
    private String qualification;
    private String file;
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
private Gender gender;
//    private Image image;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public long getPhoneNumber2() {
	return phoneNumber2;
}
public void setPhoneNumber2(long phoneNumber2) {
	this.phoneNumber2 = phoneNumber2;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
   
}
