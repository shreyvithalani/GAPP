package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.Degrees;
import gapp.model.dao.DegreesDao;


@Repository
public class DegreesDaoImpl implements DegreesDao {
	
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional
	public Degrees SubmitDegrees(Degrees degrees) {
		return entityManager.merge(degrees);
	}

	@Override
	@Transactional
	public void removeDegree(Degrees degree) {
		entityManager.remove(degree);
		
	}

	@Override
	public Degrees getDegree(Long id) {
		
		return entityManager.find(Degrees.class, id);
	}

}
