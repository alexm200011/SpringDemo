package edu.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.spring.model.Student;

public interface IStudentRepository extends CrudRepository<Student,Long>{
	 
	
	public List<Student> findByFirstNameLike(String firstName);
	
//---------------------------- Paginación --------------------------------------------------	
	Page<Student> findByLastName(String criteria, Pageable pageable);
	
	
//	@Query("SELECT st FROM Student st WHERE st.lastName LIKE %?1")
//	public List<Student> findByLastNameContains(String lastName);
	
	@Query("SELECT st FROM Student st WHERE st.lastName LIKE %:lastName%")
    public List<Student> findByLastNameContains(@Param("lastName") String lastName);
	
	
}
