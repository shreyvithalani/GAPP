package gapp.model.dao;

import java.util.List;

import gapp.model.Users;

public interface UserDao {
	
	Users getUser(Long id);
	
	Users submitUser(Users user);
	
	public Boolean isExist(String email);
	
	public List<Users> checklogin(String email,String password);
}
