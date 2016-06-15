package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "applications")
public class Application implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String term;

	@OneToMany(mappedBy = "application",cascade=CascadeType.ALL)
	@OrderBy("id desc")
	List<ApplicationStatus> applicationstatus;
	
	@OneToMany(mappedBy="application",cascade=CascadeType.ALL)
	private List<Values> values;
	
	
	@ManyToOne
	Department department;
	
	@ManyToOne
	Program program;

	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@ManyToOne
	Users users;
	
	@OneToOne
	AcademicRecords academicrecords;
	
	@OneToMany(mappedBy="application",cascade=CascadeType.ALL)
    private List<Degrees> degrees;
	
	private String lastname;
	
	private String firstname;
	
	private Integer CIN;
	
	private String phone;
	
	private String gender;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date dob;
	
	private String citizenship;
	
	private String email;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date dateofapp;
	
	
	public AcademicRecords getAcademicrecords() {
		return academicrecords;
	}


	public void setAcademicrecords(AcademicRecords academicrecords) {
		this.academicrecords = academicrecords;
	}
	
	public Date getDateofapp() {
		return dateofapp;
	}


	public void setDateofapp(Date dateofapp) {
		this.dateofapp = dateofapp;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public Integer getCIN() {
		return CIN;
	}


	public void setCIN(Integer cIN) {
		CIN = cIN;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getCitizenship() {
		return citizenship;
	}


	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public Program getProgram() {
		return program;
	}


	public void setProgram(Program program) {
		this.program = program;
	}


	public List<ApplicationStatus> getApplicationstatus() {
		return applicationstatus;
	}


	public void setApplicationstatus(List<ApplicationStatus> applicationstatus) {
		this.applicationstatus = applicationstatus;
	}


	public List<Degrees> getDegrees() {
		return degrees;
	}


	public void setDegrees(List<Degrees> degrees) {
		this.degrees = degrees;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}

	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public List<Values> getValues() {
		return values;
	}


	public void setValues(List<Values> values) {
		this.values = values;
	}
	
}
