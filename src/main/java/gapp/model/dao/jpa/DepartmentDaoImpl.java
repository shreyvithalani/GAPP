package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.dao.DepartmentDao;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Department> getDepartments() {
		return entityManager.createQuery( "from Department order by id", Department.class )
	            .getResultList();
	}

	@Override
	public Department getDepartment(Long id) {
		return entityManager.find(Department.class, id);
	}
	
	

	@Override
	public List<Program> getProgram() {
		return entityManager.createQuery("from Program order by id",Program.class).getResultList();
	}

	@Override
	@Transactional
	public Department submitdept(Department department) {
		
		return entityManager.merge(department);
	}

}
