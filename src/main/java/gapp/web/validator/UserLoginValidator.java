package gapp.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.Users;
import gapp.model.dao.UserDao;


@Component
public class UserLoginValidator implements Validator {
	
	@Autowired
	UserDao userdao;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Users.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Users user = (Users)target;
		
		
		if(!StringUtils.hasText(user.getEmail())){
			errors.rejectValue("email", "error.field.empty");
		}
		
		if(!StringUtils.hasText(user.getPassword())){
			errors.rejectValue("password", "error.field.empty");
		}
		
		if(userdao.checklogin(user.getEmail(), user.getPassword()).isEmpty()){
			errors.rejectValue("password", "error.field.match");
			
		}
	}
	
	

}
