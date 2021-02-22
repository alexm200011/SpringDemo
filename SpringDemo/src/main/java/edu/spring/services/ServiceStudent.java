package edu.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import edu.spring.model.Student;
import edu.spring.repositories.IStudentJpaRepository;
//import edu.spring.repositories.IStudentRepository;

@Service
public class ServiceStudent implements IServiceStudent{
	
	@Autowired
	//private IStudentRepository studentRepository2;
	private IStudentJpaRepository studentRepository; 
	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return (List<Student>)studentRepository.findAll();
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		return studentRepository.findByFirstNameLike(firstName); 
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Student> searchByLastName(String a) {		
		return studentRepository.findByLastNameContains(a);
	}

	//---------- Paginacion -------------------------------------------
	@Override
	public List<Student> findByLastName(String criteria, int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Student> pages;
		pages = studentRepository.findByLastName(criteria, paging);
		return pages.getContent();
	}
	
	
}
