package com.besant.Springlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.besant.Springlearn.entity.Student;

import jakarta.transaction.Transactional;

//repository must be interface
//if the repository is interface we can only declared methods and body can't be given
//if we extends jparepository mean whatever in jparepo it;s come to sudentrepo interface also

@Repository
public interface StudentRepo extends JpaRepository< Student, Integer>{
	
	//User Creation Methods to access Student name
	public List<Student> getFindByStudName(String name);
	
	
	// We need to use (Modifying) and (transactional) and then Query anotation here to write 
	// Sql query here in spring boot 
		@Modifying
		@Transactional
		@Query(value="delete from student_data where student_name=?1",nativeQuery =true)
		public void deleteBystudentName(String studentName);
		
		
	//	public void deleteBystudentName(String studentName); //we can't delete by name like using this methods
	//	that's why i'm writing Sql native Query above to delete by name

}
