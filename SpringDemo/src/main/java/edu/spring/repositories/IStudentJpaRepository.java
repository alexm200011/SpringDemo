package edu.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.spring.model.Student;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentJpaRepository extends JpaRepository<Student,Long> {
		public List<Student> findByFirstNameLike(String firstName);
	
	//---------------------------- Paginación --------------------------------------------------	
		Page<Student> findByLastName(String criteria, Pageable pageable);
		
//		@Query("SELECT st FROM Student st WHERE st.lastName LIKE %?1")
//		public List<Student> findByLastNameContains(String lastName);
		
		@Query("SELECT st FROM Student st WHERE st.lastName LIKE %:lastName%")
	    public List<Student> findByLastNameContains(@Param("lastName") String lastName);
}
