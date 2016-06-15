package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;

import gapp.model.dao.ApplicationDao;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<ApplicationStatus> studentapplication() {
		//List<ApplicationStatus> app = entityManager.createQuery( "from ApplicationStatus where users.email = 'shrey@localhost.localdomain'", StudentApplication.class )
	           // .getResultList();
		return null;
	}


	@Override
	public List<Department> department() {
		return entityManager.createQuery( "from Department where  ", Department.class )
	            .getResultList();
	}

	@Override
	public Department getDepartmentByName(String dname)	{
		Query d_query = entityManager.createQuery("select d from Department d where d.Dept_name = :dname");
		d_query.setParameter("dname", dname);
		return (Department) d_query.getSingleResult();
	}
	
	@Override
	public Application getApplicationByProgram(Integer id)	{
		Query d_query = entityManager.createQuery("select a from Application a where a.id = :id");
		d_query.setParameter("id", id);
		return (Application) d_query.getSingleResult();
	}


	@Override
	public List<Application> getApplications() {
		return entityManager.createQuery( "from Application order by id", Application.class )
	            .getResultList();
	}


	@Override
	@Transactional
	public Application SubmitApplication(Application application) {
		
		return entityManager.merge(application);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Application> getApplicationByUser(Long id) {
		return entityManager.createQuery("select a from Application a where a.id =:id").getResultList();
	}


	@Override
	public Application getApplication(Long id) {
		
		return entityManager.find(Application.class, id);
	}


	@Override
	public Application getAcademicrecords(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
	
}
