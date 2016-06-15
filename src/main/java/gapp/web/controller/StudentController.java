package gapp.web.controller;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import gapp.model.AcademicRecords;
import gapp.model.Additional;
import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Degrees;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.Users;
import gapp.model.Values;
import gapp.model.dao.AcademicRecordDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DegreesDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.StatusDao;
import gapp.model.dao.UserDao;
import gapp.model.dao.ValuesDao;

@Controller
@SessionAttributes({ "academicrecord", "application" })
public class StudentController {

	@Autowired
	ApplicationDao applicationdao;

	@Autowired
	private DepartmentDao deptdao;

	@Autowired
	private ProgramDao programdao;

	@Autowired
	private UserDao userdao;

	@Autowired
	private StatusDao statusdao;

	@Autowired
	private DegreesDao degreedao;

	@Autowired
	private AcademicRecordDao academicdao;

	@Autowired
	private ValuesDao valuesdao;

	@RequestMapping(value = "/home/student.html", method = RequestMethod.GET)
	public String applist(ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Long userid = (Long) session.getAttribute("userid");
			Users user = userdao.getUser(userid);
			models.put("application", user.getApplication());
			return "home/student";
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/application.html", method = RequestMethod.GET)
	public String deptlist(ModelMap models) {
		List<Department> dept = deptdao.getDepartments();

		models.put("depts", dept);
		return "home/application";
	}

	@RequestMapping(value = "/home/submitdept.html", method = RequestMethod.GET)
	public String getprograms(@RequestParam("dept") Long id, ModelMap models) {
		Department dept = deptdao.getDepartment(id);
		models.put("programs", dept.getPrograms());

		return "home/getprograms";

	}

	@RequestMapping(value = "/home/application.html", method = RequestMethod.POST)
	public String savedept(ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Long userid = (Long) session.getAttribute("userid");
			Users user = userdao.getUser(userid);
			Department dept = deptdao.getDepartment(Long.parseLong(request.getParameter("department")));
			Program prog = programdao.getProgram(Long.parseLong(request.getParameter("program")));

			Application application = new Application();

			application.setDepartment(dept);
			application.setProgram(prog);
			application.setTerm(request.getParameter("term"));
			application.setUsers(user);
			application = applicationdao.SubmitApplication(application);

			ApplicationStatus applicationstatus = new ApplicationStatus();
			applicationstatus.setStatus("Not Submitted");
			applicationstatus.setApplication(application);
			applicationstatus = statusdao.savestatus(applicationstatus);

			models.put("application", application);
			return "redirect:/home/basicinfo.html?id=" + application.getId();
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/basicinfo.html", method = RequestMethod.GET)
	public String basicinfo(ModelMap models, HttpServletRequest request, @RequestParam Long id) {
		HttpSession session = request.getSession();
		// models.put("application",applicationdao.getApplication(id));
		// models.put("application", new Application());
		if (session.getAttribute("userid") != null) {
			return "home/basicinfo";
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/basicinfo.html", method = RequestMethod.POST)
	public String savebasicinfo(@ModelAttribute Application application, ModelMap models, HttpServletRequest request,
			@RequestParam Long id) {
		// Application data = applicationdao.getApplication(id);
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			application = applicationdao.SubmitApplication(application);
			// data.setFirstname(application.getFirstname());
			// data.setLastname(application.getLastname());
			// data.setCIN(application.getCIN());
			// data.setEmail(application.getEmail());
			// data.setCitizenship(application.getCitizenship());
			// data.setDob(application.getDob());
			// data.setPhone(application.getPhone());
			// data.setGender(application.getGender());
			// data = applicationdao.SubmitApplication(data);
			// models.put("application", applicationdao.getApplication(id));
			return "redirect:/home/addedu.html?id=" + application.getId();
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editbasicinfo.html", method = RequestMethod.GET)
	public String editbasicinfo(ModelMap models, @ModelAttribute Application application, HttpServletRequest request,
			@RequestParam Long id) {
		HttpSession session = request.getSession();
		// models.put("application",applicationdao.getApplication(id));
		// models.put("application", new Application());
		if (session.getAttribute("userid") != null) {
			models.put("application", applicationdao.getApplication(id));
			return "home/editbasicinfo";
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/editbasicinfo.html", method = RequestMethod.POST)
	public String saveeditbasicinfo(ModelMap models, HttpServletRequest request, @RequestParam Long id,
			@ModelAttribute Application application) {
		HttpSession session = request.getSession();
		// models.put("application",applicationdao.getApplication(id));
		// models.put("application", new Application());
		if (session.getAttribute("userid") != null) {
			models.put("application", applicationdao.getApplication(id));
			application = applicationdao.SubmitApplication(application);
			return "redirect:/home/viewapp.html?id=" + application.getId();
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/editdetails.html", method = RequestMethod.GET)
	public String editdetails(ModelMap models, HttpServletRequest request, @RequestParam Long id,
			@ModelAttribute Application application) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application app = applicationdao.getApplication(id);
			// models.put("dept", app.getDepartment());
			models.put("program", app.getDepartment().getPrograms());
			models.put("application", applicationdao.getApplication(id));
			return "home/editdetails";
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/editedu.html", method = RequestMethod.GET)
	public String editedu(ModelMap models, HttpServletRequest request, @RequestParam Long id,
			@ModelAttribute Application application) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			models.put("degree", new Degrees());
			models.put("application", applicationdao.getApplication(id));
			return "home/editedu";
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/editedu.html", method = RequestMethod.POST)
	public String saveeditedu(ModelMap models, HttpServletRequest request, @RequestParam Long id,
			@ModelAttribute Application application, @ModelAttribute Degrees degree) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			// models.put("degrees", application.getDegrees());
			degree.setApplication(application);
			degree = degreedao.SubmitDegrees(degree);
			models.put("application", applicationdao.getApplication(id));
			return "redirect:/home/viewapp.html?id=" + application.getId();
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/removedegree.html", method = RequestMethod.GET)
	public String removedegree(ModelMap models, HttpServletRequest request, @RequestParam Long id,
			@ModelAttribute Application application, @RequestParam Long id2) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {

			degreedao.removeDegree(degreedao.getDegree(id));
			models.put("application", applicationdao.getApplication(id2));
			return "redirect:/home/viewapp.html?id=" + id2;
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/editdetails.html", method = RequestMethod.POST)
	public String saveditdetails(ModelMap models, HttpServletRequest request, @RequestParam("id") Long id,
			@ModelAttribute Application application) {
		HttpSession session = request.getSession();

		if (session.getAttribute("userid") != null) {

			application = applicationdao.SubmitApplication(application);
			models.put("application", application);

			return "redirect:/home/viewapp.html?id=" + application.getId();
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/editacademic.html", method = RequestMethod.GET)
	public String editacademic(@ModelAttribute Application application, @RequestParam() Long id, ModelMap models,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application a = applicationdao.getApplication(id);
			models.put("academic", a.getAcademicrecords());
			models.put("application", a);
			return "home/editacademic";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/editacademic.html", method = RequestMethod.POST)
	public String saveeditacademic(@ModelAttribute Application application, @RequestParam() Long id,
			@ModelAttribute AcademicRecords academicrecords, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application a = applicationdao.getApplication(id);
			AcademicRecords record = a.getAcademicrecords();
			record.setGrescore(academicrecords.getGrescore());
			record.setGpa(academicrecords.getGpa());
			record.setToeflscore(academicrecords.getToeflscore());
			// academicrecords.setApplication(application);
			record = academicdao.SubmitAcademicRecords(record);
			application.setAcademicrecords(record);
			application = applicationdao.SubmitApplication(application);
			models.put("academicrecord", record);
			models.put("application", application);
			return "redirect:/home/viewapp.html?id=" + id;
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/addedu.html", method = RequestMethod.GET)
	public String addedu(ModelMap models, HttpServletRequest request, @ModelAttribute Application application) {
		HttpSession session = request.getSession();
		System.out.println(application.getId());
		Application a = applicationdao.getApplication(application.getId());
		models.put("application", a);
		models.put("degrees", a.getDegrees());
		if (session.getAttribute("userid") != null) {
			// Application app =
			// applicationdao.getApplication(application.getId());
			// applicationdao.SubmitApplication(application);
			return "home/addedu";
		} else {
			return "redirect:/home/login.html";
		}

	}

	@RequestMapping(value = "/home/educationalbackground.html", method = RequestMethod.GET)
	public String educationalBackground(@ModelAttribute Application application, ModelMap models,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			models.put("degree", new Degrees());
			return "home/educationalbackground";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/add.html", method = RequestMethod.GET)
	public String add(@ModelAttribute Application application, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application a = applicationdao.getApplication(application.getId());
			Department d = a.getDepartment();
			List<Additional> adds = d.getAdditional();
			List<Values> values = new ArrayList<Values>();
			for (Additional add : adds) {
				Values value = new Values();
				value.setAdditional(add);
				value.setApplication(a);
				values.add(value);
			}
			a.setValues(values);
			models.put("application", a);

			return "home/add";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/add.html", method = RequestMethod.POST)
	public String submitadd(@ModelAttribute Application application, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Application a = applicationdao.getApplication(application.getId());
		if (session.getAttribute("userid") != null) {
			for (int i = 0; i < application.getValues().size(); i++) {
				Values value = application.getValues().get(i);
				if (!value.getAdditional().getType().equals("file")) {
					Values v = new Values();
					v.setApplication(a);
					v.setAdditional(value.getAdditional());
					v.setValue(value.getValue());
					System.out.println(v.getValue());
					System.out.println(v.getAdditional().getType());
					v = valuesdao.saveValue(v);
				}
			}
			Application application2 = applicationdao.getApplication(a.getId());
			models.put("application", application2);
			return "redirect:/home/addupload.html";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/addupload.html", method = RequestMethod.GET)
	public String addupload(@ModelAttribute Application application, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			List<Values> values = new ArrayList<Values>();
			Application a = applicationdao.getApplication(application.getId());
			for (int i = 0; i < a.getDepartment().getAdditional().size(); i++) {
				Values value = new Values();
				value.setAdditional(a.getDepartment().getAdditional().get(i));
				value.setApplication(a);
				values.add(value);
			}
			a.setValues(values);
			models.put("application", a);
			return "home/addupload";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/addupload.html", method = RequestMethod.POST)
	public String addupload1(@ModelAttribute Application application, ModelMap models,
			@RequestParam("file") MultipartFile[] files, HttpServletRequest request)
					throws IllegalStateException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("userid") != null) {
			if(files != null) {
			Integer fileIndex = 0;
			Application a = applicationdao.getApplication(application.getId());
			for (int i = 0; i < application.getValues().size(); i++) {
				Values v = application.getValues().get(i);
				if (v.getAdditional().getType().equals("file")) {
					v.setApplication(a);
					File f = new File(files[fileIndex].getOriginalFilename());
					files[fileIndex].transferTo(f);
					v.setFilevalue(f);
					v = valuesdao.saveValue(v);
					}
					fileIndex++;
				

			}
			

			Application application2 = applicationdao.getApplication(a.getId());
			models.put("application", application2);
			

			return "redirect:/home/academicrecord.html";
			} else {
				return "redirect:/home/addupload.html";
			}
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/educationalbackground.html", method = RequestMethod.POST)
	public String eduBackground(@ModelAttribute Application application, @ModelAttribute Degrees degree,
			ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			degree.setApplication(application);
			degree = degreedao.SubmitDegrees(degree);
			models.put("application", applicationdao.getApplication(application.getId()));
			// application = applicationdao.SubmitApplication(application);
			return "redirect:/home/addedu.html";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/academicrecord.html", method = RequestMethod.GET)
	public String academic(@ModelAttribute Application application, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			models.put("academic", new AcademicRecords());
			models.put("application", applicationdao.getApplication(application.getId()));
			return "home/academicrecord";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/academicrecord.html", method = RequestMethod.POST)
	public String saveacademic(@ModelAttribute Application application, @ModelAttribute AcademicRecords academicrecords,
			ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application a = applicationdao.getApplication(application.getId());
			academicrecords.setApplication(a);
			academicrecords = academicdao.SubmitAcademicRecords(academicrecords);
			a.setAcademicrecords(academicrecords);
			a = applicationdao.SubmitApplication(a);
			models.put("academicrecord", academicrecords);
			models.put("application", applicationdao.getApplication(a.getId()));
			return "redirect:/home/uploadtranscript.html";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/uploadtranscript.html", method = RequestMethod.GET)
	public String upload(@ModelAttribute Application application, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {

			return "home/uploadtranscript";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/uploadtranscript.html", method = RequestMethod.POST)
	public String uploadpost(@ModelAttribute Application application, ModelMap models, HttpServletRequest request,
			@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			if (request.getParameter("submit") != null) {
				if (!file.isEmpty()) {
					ApplicationStatus applicationstatus = new ApplicationStatus();
					applicationstatus.setStatus("Submitted");
					applicationstatus.setApplication(application);
					applicationstatus = statusdao.savestatus(applicationstatus);
					File f = new File(file.getOriginalFilename());
					file.transferTo(f);
					Application app = applicationdao.getApplication(application.getId());
					app.setDateofapp(new Date());
					AcademicRecords academic = app.getAcademicrecords();

					academic.setTranscript(f);
					academic = academicdao.SubmitAcademicRecords(academic);
					return "redirect:/home/student.html";
				} else {
					ApplicationStatus applicationstatus = new ApplicationStatus();
					applicationstatus.setStatus("Submitted");
					Application app = applicationdao.getApplication(application.getId());
					app.setDateofapp(new Date());
					applicationstatus.setApplication(application);
					applicationstatus = statusdao.savestatus(applicationstatus);
					return "redirect:/home/student.html";
				}
			} else {

				if (!file.isEmpty()) {
					File f = new File(file.getOriginalFilename());
					file.transferTo(f);
					Application app = applicationdao.getApplication(application.getId());
					System.out.println(app);
					System.out.println(app.getAcademicrecords().getId());
					AcademicRecords academic = app.getAcademicrecords();
					System.out.println(academic);
					System.out.println(file.getOriginalFilename());
					academic.setTranscript(f);
					academic = academicdao.SubmitAcademicRecords(academic);
					return "redirect:/home/student.html";
				}
			}
			return "redirect:/home/student.html";

		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/upload.html", method = RequestMethod.GET)
	public String upload1(@ModelAttribute Application application, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application a = applicationdao.getApplication(application.getId());
			models.put("application", applicationdao.getApplication(a.getId()));
			return "home/upload";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/upload.html", method = RequestMethod.POST)
	public String saveupload1(@ModelAttribute Application application, @RequestParam("id") Long id, ModelMap models,
			HttpServletRequest request, @RequestParam MultipartFile file) throws IllegalStateException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			if (!file.isEmpty()) {
				File f = new File(file.getOriginalFilename());
				file.transferTo(f);
				Application a = applicationdao.getApplication(id);
				AcademicRecords academic = a.getAcademicrecords();
				academic.setTranscript(f);
				academic = academicdao.SubmitAcademicRecords(academic);
				a.setAcademicrecords(academic);
				a = applicationdao.SubmitApplication(a);
				models.put("application", a);
				return "redirect:/home/viewapp.html?id=" + id;
			}
			return "redirect:/home/viewapp.html?id=" + id;
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/download.html", method = RequestMethod.GET)
	public String download(@ModelAttribute Application application, ModelMap models, HttpServletRequest request,
			@RequestParam Long id, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application app = applicationdao.getApplication(id);
			File file = app.getAcademicrecords().getTranscript();
			// ServletContext context = request.getServletContext();
			// String filepath = context.
			// String mimetype = context.getMimeType(file.getName());
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=" + file.getName());

			FileInputStream in = new FileInputStream(file);

			OutputStream out = response.getOutputStream();

			byte buffer[] = new byte[2048];

			int bytesRead;

			while ((bytesRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, bytesRead);
			}
			in.close();
			response.flushBuffer();

			return null;
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/adddownload.html", method = RequestMethod.GET)
	public String adddownload(@ModelAttribute Application application, ModelMap models, HttpServletRequest request,
			@RequestParam Long id, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Values value = valuesdao.getValue(id);
			File file = value.getFilevalue();
			// ServletContext context = request.getServletContext();
			// String filepath = context.
			// String mimetype = context.getMimeType(file.getName());
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=" + file.getName());

			FileInputStream in = new FileInputStream(file);

			OutputStream out = response.getOutputStream();

			byte buffer[] = new byte[2048];

			int bytesRead;

			while ((bytesRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, bytesRead);
			}
			in.close();
			response.flushBuffer();

			return null;
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/viewapp.html", method = RequestMethod.GET)
	public String viewapp(@ModelAttribute Application application, ModelMap models, HttpServletRequest request,
			@RequestParam Long id) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			models.put("application", applicationdao.getApplication(id));

			return "home/viewapp";
		} else {
			return "redirect:/home/login.html";
		}
	}

	@RequestMapping(value = "/home/submitapp.html", method = RequestMethod.GET)
	public String submitapp(@ModelAttribute Application application, ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			Application app = applicationdao.getApplication(application.getId());
			ApplicationStatus applicationstatus = new ApplicationStatus();
			applicationstatus.setStatus("Submitted");
			applicationstatus.setApplication(application);
			applicationstatus = statusdao.savestatus(applicationstatus);
			app.setDateofapp(new Date());
			app = applicationdao.SubmitApplication(app);
			models.put("application", app);

			return "redirect:/home/student.html";
		} else {
			return "redirect:/home/login.html";
		}
	}

}
