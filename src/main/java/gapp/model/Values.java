package gapp.model;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "values")
public class Values {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long Id;
	
	private String value;
	
	private File filevalue;
	
	@ManyToOne
	private Application application;
	
	@ManyToOne
	private Additional additional;
	
	public Values() {
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public File getFilevalue() {
		return filevalue;
	}

	public void setFilevalue(File filevalue) {
		this.filevalue = filevalue;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Additional getAdditional() {
		return additional;
	}

	public void setAdditional(Additional additional) {
		this.additional = additional;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}
