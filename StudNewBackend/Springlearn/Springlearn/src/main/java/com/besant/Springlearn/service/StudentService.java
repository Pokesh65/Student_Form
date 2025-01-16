package com.besant.Springlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.besant.Springlearn.entity.Student;
import com.besant.Springlearn.repository.StudentRepo;

@Service
public class StudentService {
	
//	this auto wired used to link that bean to the services 

	
	@Autowired
	private StudentRepo studRepo;
	
	public String CreateSt( Student std) {
		
		studRepo.save(std);
		return "Created"; 
	}
	
//	To fetch all the datas from the database methods is here
//	whatever the methods we created in controller must be created here in services also
	public List<Student> getStudents(){
		return studRepo.findAll(); //this findAll similar to select*from student
		//find all to find all student object in the list 
//		it will fetch all the object value
	}

//	Fetch Some Specific data From the api with the id
	public Student getStudentById(int id) {
//		the optional value must return the value of null value
		 Optional<Student> getStud=studRepo.findById(id);
//		 we are using is present option if the value is here print the if part else print else part
		 if(getStud.isPresent()) {
			 
			 return studRepo.findById(id).get();
		 }
		 else {
			System.out.println("we don't have the data which is belongs to that id");
		}
		return null;
	}
	
//	Delete the Student data with id
	public String  DeleteStudentById(int id) {
		studRepo.deleteById(id);
		return "Deleted";
		
	}
	
//Update The Student Data with id
	 public String Updatevalue(Student st){
		 Optional<Student> Do=studRepo.findById(st.getStudId());
		 
			if(Do.isPresent()) {
				Student newDo=Do.get();
				// this isBlank is check whether the value is here or not
				// if there is value here then this condition will execute
				if(!st.getStudName().isBlank()) {
					newDo.setStudName(st.getStudName());
				}
				if(!st.getStudCourse().isBlank()) {
					newDo.setStudCourse(st.getStudCourse());
				}
				newDo.setStudYear(st.getStudYear());
				
				studRepo.save(newDo);
			}else {
				return "These Type of value not Found here";
			}
			return "Data Updated";
		 
	 }
	 
	 
//	Update Student Data Using PathVariable
	 public String uppath(int studId, Student tt) {
		    // Try to find the student by ID
		    Optional<Student> optionalStudent = studRepo.findById(studId);

		    // Check if the student exists
		    if (!optionalStudent.isPresent()) {
		        return "Irunga Bhaii... Data illa";
		    }

		    // Retrieve the student object from the Optional
		    Student existingStudent = optionalStudent.get();

		    // Update fields if the new values are not blank
		    if (!tt.getStudName().isBlank()) {
		        existingStudent.setStudName(tt.getStudName());
		    }
		    if (!tt.getStudCourse().isBlank()) {
		        existingStudent.setStudCourse(tt.getStudCourse());
		    }

		    // Update the student year without a blank check (assuming it's a required field)
		    existingStudent.setStudYear(tt.getStudYear());

		    // Save the updated student entity to the repository
		    studRepo.save(existingStudent);

		    return "Updated";
		}
	 
	 
// Find Student data by Student Name here
	  public List<Student> nameFind(String studName){
		return studRepo.getFindByStudName(studName);
		  
	  }
	 
	 
}


