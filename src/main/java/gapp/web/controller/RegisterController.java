package gapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gapp.model.Users;
import gapp.model.dao.UserDao;
import gapp.web.validator.RegisterValidator;

@Controller
public class RegisterController {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private RegisterValidator valid;
	
	@RequestMapping(value = "/home/register.html",method = RequestMethod.GET)
	public String register(ModelMap models){
		models.put("user", new Users());
		return "/home/register";
	}
	
	
	@RequestMapping(value = "/home/register.html", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") Users user,BindingResult result){
		//System.out.println(user.getFirstname());
		valid.validate(user, result);
		if(result.hasErrors()) return "home/register";
		
		user = userdao.submitUser(user); 
		
		return "redirect:/home/login.html";
	}
	

	
	@RequestMapping("/home/staff.html")
	public String staff(){
		return "/home/staff";
	}
	
	@RequestMapping("/home/student.html")
	public String student(){
		return "/home/student";
	}
}
