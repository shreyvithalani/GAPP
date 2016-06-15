package gapp.model.dao;

import java.util.List;


import gapp.model.Department;
import gapp.model.Program;

public interface DepartmentDao {
	
	Department submitdept(Department department);
	
	Department getDepartment(Long id);
	
	List<Department> getDepartments();
	
	List<Program> getProgram();

	
	


}
