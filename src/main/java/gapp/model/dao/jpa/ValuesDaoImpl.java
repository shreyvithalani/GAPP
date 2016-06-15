package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Values;
import gapp.model.dao.ValuesDao;

@Repository
public class ValuesDaoImpl implements ValuesDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Values getValue(Long id) {
		return entityManager.find(Values.class, id);
	}

	@Override
	@Transactional
	public Values saveValue(Values value) {
		return entityManager.merge(value);
	}

}
