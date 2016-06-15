package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Additional;
import gapp.model.dao.AdditionalDao;


@Repository
public class AdditionalDaoImpl implements AdditionalDao {
	
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional
	public Additional submitAdditional(Additional additional) {
		
		return entityManager.merge(additional);
	}

	@Override
	public Additional getAdditional(Long id) {
		
		return entityManager.find(Additional.class, id);
	}

	@Override
	@Transactional
	public void removeAdditional(Additional additional) {
		
		entityManager.remove(additional);
	}

	

}
