package edu.spring.services;

import java.util.List;

import edu.spring.model.Student;

public interface IServiceStudent {
	
	public void save(Student student);
	public Student findById(Long id);
	public void delete(Long id);
	public List<Student> findAll();
	
	public List<Student> findByFirstName(String firstName);
	public List<Student> searchByLastName(String a);
	
	//------------------Paginacion------------------------
	public List<Student> findByLastName(String criteria, int page, int size);
	
	
}
