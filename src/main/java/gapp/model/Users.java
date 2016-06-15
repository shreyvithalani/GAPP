package gapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")

public class Users implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String lastname;
	
	private String firstname;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String password;
	
	@ElementCollection
    @CollectionTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;
 
	public Set<String> getRoles() {
	return roles;
	}
	
	public Users(){
		roles = new HashSet<String>();
	}
	
	public boolean isUserAdmin(){
		return roles.contains("Admin");
	}
	
	public boolean isUserStaff(){
		return roles.contains("Staff");
	}
	
	@OneToMany(mappedBy = "users",cascade=CascadeType.ALL)
	List<Application> application;
	
	@OneToMany(mappedBy = "users",cascade=CascadeType.ALL)
	List<ApplicationStatus> applicationstatus;
	
	public List<ApplicationStatus> getApplicationstatus() {
		return applicationstatus;
	}

	public void setApplicationstatus(List<ApplicationStatus> applicationstatus) {
		this.applicationstatus = applicationstatus;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
