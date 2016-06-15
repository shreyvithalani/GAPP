package gapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gapp.model.Users;
import gapp.model.dao.UserDao;
import gapp.web.validator.UserLoginValidator;



@Controller
public class UserLoginController {
	
	@Autowired
	private UserLoginValidator userloginvalidator;
	
	@Autowired
	private UserDao userdao;
	
	@RequestMapping(value = "/home/login.html", method = RequestMethod.GET)
	public String login(ModelMap models){
		models.put("user", new Users());
		models.put("message", "Please login here");
		return "home/login";
	}
	
	@RequestMapping(value = "/home/login.html", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") Users user,BindingResult result,ModelMap models, HttpServletRequest request){
		userloginvalidator.validate(user, result);
		if(result.hasErrors()) return "home/login";
		Users user2 = userdao.checklogin(user.getEmail(),user.getPassword()).get(0);
		
		
		if(user2.isUserAdmin()){
			Long user_id = user2.getId();
			request.getSession().setAttribute("userid", user_id);
			return "redirect:/home/admin.html";
			
		}
		else if(user2.isUserStaff()){
			return "redirect:/home/staff.html";
		}
		else{
			//models.put("user", user);
			Long user_id = user2.getId();
			request.getSession().setAttribute("userid", user_id);
			return "redirect:/home/student.html";
		}
		
		
	}
	
	@RequestMapping(value="/home/logout.html")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/home.html";	
	}
	


}
