
package com.besant.Springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.besant.Springlearn.entity.Student;
import com.besant.Springlearn.service.StudentService;

//Whith this crossOrigin we need to teel the server whoever access our data if we give * every one can access out data
//or if we give some url that url can only acess our data
@CrossOrigin(origins = "*")


//to let know the spring boot to that this is controller you need to @RestController
@RestController

//if u have 10controller then how will you tell to the fron-end to which controller to get
//So we need to assign some name to call it from fron-end

@RequestMapping("/Student")
public class StudController {
	
	@Autowired 
	private StudentService studService;
	
//	front-end calling this methods
//	so let them call this method we need to assign one name for it
//	we don't get anything from user as a input so we need to use get mapping methods
//	if we have anything as a input like name roll no we need use post mapping methods
//	if we need to delete anything from what they give use delete mapping methods 
//	if we need to update anything from what they give we use put mapping
	
	@GetMapping("/List")
	public String getData() {
		return "Welcome To My First Api  "+"  Student Details Name = Pokesh Kumar Age  = 22Phone= 6383532388";
	}
	
	
	@GetMapping("/List1")
	public String getData1() {
		return "Hello Pokesh Welcome To My Api";
	}
	
	@PostMapping("/createStud")
//	to send data from front-end api to let know that java files we need to use requestBody anotation
	public String createStud(@RequestBody Student stud) {
		
		return studService.CreateSt(stud);
		
	}
	
//	To fetch all the data s from the database methods is here 
//	With these methods we can get all the data from the database here
//	we need to give it here and StudentService.methods also which we created in services
	
	@GetMapping("/ListOfStudent")
	public List<Student> getAll(){
//		here we need to tell many Student value come here so we need to give List<Student> here
//		if here comes only one data then wee need to give Student only
//		here we need to call that method(getStudents) we created in service
		return studService.getStudents();
	}
	
	
	
//	find students by id we need to create some methods 
	@GetMapping("/FindById")
	public Student getFindById(@RequestParam int id) {
		return  studService.getStudentById(id);
	}
	
//	Delete Api
	//Delete data value by id
	@DeleteMapping("/DStudent")
	public String DeleteById(@RequestParam int id) {
		return studService.DeleteStudentById(id);
	}
	
// Update Api
	//	it will update the existing values
	@PostMapping("/Update")
	public String UpdateById(@RequestBody Student st){
		return studService.Updatevalue(st);
		
	}
	
// Update Api 
	// Update Datas Using Path Variable
	@PostMapping("/UpdatePath/{studId}")
	public String UpdatePath(@PathVariable("studId") int studId,@RequestBody Student tt){
		return studService.uppath(studId,tt);
		
	}
	
// Find by Student Name using pathvariable
	@GetMapping("/findname/{name}")
	public List<Student> FindName(@PathVariable("name") String studName){
		return studService.nameFind(studName);
		
	}
	

}

