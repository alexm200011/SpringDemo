package edu.spring.controllers;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.utils.ResponseUtility;
import edu.spring.model.Student;
import edu.spring.services.IServiceStudent;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/student")

public class StudentController {
	
	
	private IServiceStudent service;
	
	public StudentController(IServiceStudent servicestudent)
    {
        service = servicestudent;
    }
	
	public void setCustomerDataAccess(IServiceStudent custDataAccess) {
        service = custDataAccess;
    }
	
	@GetMapping("")
	public List<Student> findAll(){
		return service.findAll();
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Student save(@RequestBody Student student) {
		service.save(student);
		return student;
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Student update(@RequestBody Student student, @PathVariable Long id) {		 			
		service.save(student);
		return student;
	}
	
	
	@GetMapping("/search/lastname/{lastName}")	
	public ResponseEntity<?> listByLastName(@PathVariable String lastName) {
		try {
			List<Student> st = service.searchByLastName(lastName);
			if(st.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not students found");	
			}
			return ResponseEntity.ok(st);
		}
		catch(Exception ex) {
			return new ResponseEntity<ResponseUtility>(new ResponseUtility(ex.getMessage(), ex), HttpStatus.BAD_REQUEST);
		}
	}

	//-------------------Paginación-------------------------------
	
	@GetMapping("/studentspage")
	public List<Student> findByLastName(
			@RequestParam(defaultValue="") String lastName, 
			@RequestParam(defaultValue="0") int page, 
			@RequestParam(defaultValue="3") int size){
		return service.findByLastName(lastName, page, size);
	}
	
}
