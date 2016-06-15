package gapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "department")
public class Department implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long Id;
	
	private String Dept_name;
	
	@OneToMany(mappedBy ="department",cascade=CascadeType.ALL)
	List<Program> programs;
	

	@OneToMany(mappedBy ="department",cascade=CascadeType.ALL)
	List<Additional> additional;
	
	@OneToMany(mappedBy ="department",cascade=CascadeType.ALL)
	List<Application> application;
	
	
	public List<Application> getApplication() {
		return application;
	}


	public void setApplication(List<Application> application) {
		this.application = application;
	}


	public Department(){
		programs = new ArrayList<Program>();
		additional = new ArrayList<Additional>();
	}
	

	public List<Additional> getAdditional() {
		return additional;
	}

	public void setAdditional(List<Additional> additional) {
		this.additional = additional;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDept_name() {
		return Dept_name;
	}

	public void setDept_name(String dept_name) {
		Dept_name = dept_name;
	}
	
	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}


	public void addProgram(Program program) {
		this.getPrograms().add(program);
		
	}
	
}
