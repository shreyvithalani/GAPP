package gapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import gapp.model.Additional;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.dao.AdditionalDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;

@Controller
public class AdminController {

	@Autowired
	private DepartmentDao deptdao;

	@Autowired
	private ProgramDao programdao;

	@Autowired
	private AdditionalDao additionaldao;

	@RequestMapping("/home/admin.html")
	public String deptlist(ModelMap models,HttpServletRequest request) {
		List<Department> dept = deptdao.getDepartments();
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){

		models.put("dept", dept);
		return "home/admin";
		}
		else{
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/department.html", method = RequestMethod.GET)
	public String adddept(ModelMap models,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
			models.put("dept", new Department());
			return "home/department";
		}
		else{
			return "redirect:/home/login.html";
		}
		
	}

	@RequestMapping(value = "/home/department.html", method = RequestMethod.POST)
	public String adddeptpost(@ModelAttribute("dept") Department dept, ModelMap models,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
			dept = deptdao.submitdept(dept);
			return "redirect:/home/admin.html";
		}
		else{
			return "redirect:/home/login.html";
		}
		
		
	}

	@RequestMapping(value = "/home/program.html", method = RequestMethod.GET)
	public String adddprogram(@RequestParam Long id, ModelMap models,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		Program program = new Program();
		models.put("program", program);
		models.put("department", deptdao.getDepartment(id));
		return "home/program";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/program.html", method = RequestMethod.POST)
	public String submitprogram(@ModelAttribute("program") Program program,
			@ModelAttribute("department") Department department, @RequestParam Long id, ModelMap models,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		
		program.setDepartment(deptdao.getDepartment(id));
		program = programdao.submitProgram(program);
		return "redirect:/home/admin.html";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/additional.html", method = RequestMethod.GET)
	public String getadditional(@RequestParam Long id, ModelMap models,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		Additional additional = new Additional();
		models.put("additional", additional);
		return "home/additional";
		}
		else{
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/additional.html", method = RequestMethod.POST)
	public String submitAdditional(@ModelAttribute("additional") Additional additional, @RequestParam Long id,
			ModelMap models,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		additional.setDepartment(deptdao.getDepartment(id));
		additional = additionaldao.submitAdditional(additional);
		return "redirect:/home/admin.html";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/view.html", method = RequestMethod.GET)
	public String showview(ModelMap models, @RequestParam Long id,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		models.put("department", deptdao.getDepartment(id));
		return "home/view";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editdepartment.html", method = RequestMethod.GET)
	public String edit(@RequestParam Long id, ModelMap models,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		models.put("department", deptdao.getDepartment(id));
		return "home/editdepartment";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editdepartment.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("department") Department department, SessionStatus sessionStatus,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		deptdao.submitdept(department);
		sessionStatus.setComplete();
		return "redirect:/home/admin.html";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editprogram.html", method = RequestMethod.GET)
	public String editprogram(@RequestParam Long id, ModelMap models,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		models.put("program", programdao.getProgram(id));
		return "home/editprogram";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editprogram.html", method = RequestMethod.POST)
	public String editprogram(@ModelAttribute("program") Program program, @RequestParam Long id, @RequestParam Long id2,
			SessionStatus sessionStatus,HttpServletRequest request) {
		// System.out.println(id);
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		program.setDepartment(deptdao.getDepartment(id2));
		program.setId(id);
		programdao.submitProgram(program);
		sessionStatus.setComplete();
		return "redirect:/home/admin.html";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editadditional.html", method = RequestMethod.GET)
	public String editadditional(@RequestParam Long id, ModelMap models,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		models.put("additional", additionaldao.getAdditional(id));
		return "home/editadditional";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editadditional.html", method = RequestMethod.POST)
	public String editadditional(@ModelAttribute("additional") Additional additional, @RequestParam Long id,
			@RequestParam Long id2, SessionStatus sessionStatus,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		additional.setDepartment(deptdao.getDepartment(id2));
		additional.setId(id);
		additionaldao.submitAdditional(additional);
		sessionStatus.setComplete();
		return "redirect:/home/admin.html";
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/removeadditional.html", method = RequestMethod.GET)
	public String removeadditional(@RequestParam Long id, ModelMap models, @RequestParam Long id2,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		additionaldao.removeAdditional(additionaldao.getAdditional(id));
		System.out.println(id2);
		return "redirect:/home/view.html?id=" + id2;
		}
		else{
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/removeprogram.html", method = RequestMethod.GET)
	public String removeProgram(@RequestParam Long id, ModelMap models, @RequestParam Long id2,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null){
		
		programdao.removeProgram(programdao.getProgram(id));
		System.out.println(id2);
		return "redirect:/home/view.html?id=" + id2;
		}
		else{
			return "redirect:/home/login.html";
		}
	}

}
