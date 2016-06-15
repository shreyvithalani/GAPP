package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import gapp.model.Program;
import gapp.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional
	public Program submitProgram(Program program) {
		
		return entityManager.merge(program);
	}

	@Override
	public Program getProgram(Long id) {
		
		return entityManager.find(Program.class, id);
	}

	@Override
	@Transactional
	public void removeProgram(Program program) {
		entityManager.remove(program);
		
	}

	@Override
	public List<Program> getProgram() {
		return entityManager.createQuery( "from Program order by id", Program.class )
	            .getResultList();
	}

}
