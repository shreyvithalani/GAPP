package gapp.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Degrees")
public class Degrees implements Serializable{
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String degree;
	
	private String univname;
	
	private String major;
	
	
	@DateTimeFormat(pattern="yyyy")
	private Date start_year;
	
	@DateTimeFormat(pattern="yyyy")
	private Date end_year;
	
	
	@ManyToOne
	Application application;
	
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getUnivname() {
		return univname;
	}

	public void setUnivname(String univname) {
		this.univname = univname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getStart_year() {
		return start_year;
	}

	public void setStart_year(Date start_year) {
		this.start_year = start_year;
	}

	public Date getEnd_year() {
		return end_year;
	}

	public void setEnd_year(Date end_year) {
		this.end_year = end_year;
	}

	
	

}
