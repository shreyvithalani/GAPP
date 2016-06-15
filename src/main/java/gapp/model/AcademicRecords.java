package gapp.model;

import java.io.File;
import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Academic_Records")
public class AcademicRecords implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String Toeflscore;
	
	private String Grescore;
	
	private Double gpa;
	
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	private File transcript;
	
	@OneToOne
	Application application;
	
	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public File getTranscript() {
		return transcript;
	}

	public void setTranscript(File transcript) {
		this.transcript = transcript;
	}

	

	public String getToeflscore() {
		return Toeflscore;
	}

	public void setToeflscore(String toeflscore) {
		Toeflscore = toeflscore;
	}

	public String getGrescore() {
		return Grescore;
	}

	public void setGrescore(String grescore) {
		Grescore = grescore;
	}
	

}
