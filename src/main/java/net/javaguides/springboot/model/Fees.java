package net.javaguides.springboot.model;

import java.lang.annotation.Repeatable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Fees")
public class Fees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	
	@Column(name = "class")
	private int classNumber;
	
	@Column(name = "fees")
	private int fees;

	public Fees() {
		
	}

	public Fees(long id, String name, int classNumber, int fees) {
		super();
		this.id = id;
		this.name = name;
		this.classNumber = classNumber;
		this.fees = fees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
	
	

}
