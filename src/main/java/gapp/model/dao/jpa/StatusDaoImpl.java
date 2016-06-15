package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.ApplicationStatus;
import gapp.model.dao.StatusDao;


@Repository
public class StatusDaoImpl implements StatusDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional
	public ApplicationStatus savestatus(ApplicationStatus applicationstatus) {
		
		return entityManager.merge(applicationstatus);
	}

}
