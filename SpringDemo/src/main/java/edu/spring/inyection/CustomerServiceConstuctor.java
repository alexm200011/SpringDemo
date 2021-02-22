package edu.spring.inyection;

import java.util.List;

import edu.spring.controllers.StudentController;
import edu.spring.services.ServiceStudent;
import edu.spring.model.Student;

public class CustomerServiceConstuctor {
	
	//Crea CustomerBusinessLogic
			StudentController _stController;
			
			
			//Inyecta CustamerDataAccess dentro de CustomerBusinessLogic
			public CustomerServiceConstuctor()
		    {
		        _stController = new StudentController(new ServiceStudent());
		    }
			
			//En el setter 
			public void setCustomerDataAccess() 
			{
			        _stController.setCustomerDataAccess(new ServiceStudent());
			}

		    public List<Student> findAll(){
		        return _stController.findAll();
		    }
}
