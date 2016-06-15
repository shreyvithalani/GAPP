package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AcademicRecords;
import gapp.model.dao.AcademicRecordDao;


@Repository
public class AcademicRecordsDaoImpl implements AcademicRecordDao {
	
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional
	public AcademicRecords SubmitAcademicRecords(AcademicRecords academicrecords) {
		
		return entityManager.merge(academicrecords);
	}

}
