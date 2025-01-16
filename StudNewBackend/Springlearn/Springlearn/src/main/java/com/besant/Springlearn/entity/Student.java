package com.besant.Springlearn.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="studentdb")
public class Student {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studId;
	
	
	@Column(name="name") //Assigning a coloum by using @coloum annotation
	private String studName; // creating a coloum name here
	
	@Column(name="course")
	private String studCourse;
	
	@Column(name="year")
	private int studYear;
	

	// Creating a getter setter for all instance variable that we created above
	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudCourse() {
		return studCourse;
	}

	public void setStudCourse(String studCourse) {
		this.studCourse = studCourse;
	}

	public int getStudYear() {
		return studYear;
	}

	public void setStudYear(int studYear) {
		this.studYear = studYear;
	}
	
	

}
