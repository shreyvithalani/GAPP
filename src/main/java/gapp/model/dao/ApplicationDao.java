package gapp.model.dao;

import java.util.List;

import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;


public interface ApplicationDao {
	
	List<ApplicationStatus> studentapplication();
	
	List<Department> department();
	
	List<Application> getApplications();

	Department getDepartmentByName(String dname);

	Application getApplicationByProgram(Integer id);
	
	Application SubmitApplication(Application application);
	
	List<Application> getApplicationByUser(Long id);
	
	Application getApplication(Long id);
	
	Application getAcademicrecords(Long id);
	
	
}
