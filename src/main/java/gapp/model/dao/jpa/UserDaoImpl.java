package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Users;
import gapp.model.dao.UserDao;


@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	Integer count = 0;

	@Override
	public Users getUser(Long id) {
		
		return entityManager.find(Users.class , id);
	}

	@Override
	@Transactional
	public Users submitUser(Users user) {
		
		return entityManager.merge(user);
	}

	@Override
	public Boolean isExist(String email) {
		
		Boolean isExist = false;
		List<Users> user = entityManager.createQuery("from Users",Users.class).getResultList();
		if(!user.isEmpty()) {
			for(Users u : user) {
				if(u.getEmail().equalsIgnoreCase(email)) {
					isExist = true;
				}
			}
		}
		return isExist;
	}

	@Override
	public List<Users> checklogin(String email, String password) {
		List<Users> user = entityManager.createQuery("from Users where email =:email and password =:password" ,Users.class).setParameter("email",email).setParameter("password",password).getResultList();
		return user;
	}

}
