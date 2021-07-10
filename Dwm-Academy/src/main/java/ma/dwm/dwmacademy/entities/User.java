package ma.dwm.dwmacademy.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.dwm.dwmacademy.utils.Enum_gender;
import ma.dwm.dwmacademy.utils.Enum_userType;

@Entity
@Table(name = "USERS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {
	
//	@NotBlank(message = "First name is mandatory")
//	@Size(min = 4, max = 50, message = "First name length should be betweeen 4 to 50 caracters")
	@Column(nullable = false, length = 50)
	private String first_name;
	
//	@NotBlank(message = "Last name is mandatory")
//	@Size(min = 4, max = 50, message = "Last name length should be betweeen 4 to 50 caracters")
	@Column(nullable = false, length = 50)
	private String last_name;
	
//	@NotBlank(message = "Email is mandatory")
//	@Size(min = 4, max = 100, message = "First name length should be betweeen 4 to 100 caracters")
//	@Email(message = "Email should be valid")
	@Column(nullable = false, length = 100)
	private String email;
	
	private String title;
	
//	@NotBlank(message = "Date of birth is mandatory")
	@Temporal(TemporalType.DATE)
	private Date date_birth;
	
	@JsonIgnore
//	@NotBlank(message = "Password is mandatory")
//	@Size(min = 4, max = 50, message = "Password lenth should be betweeen 4 to 50 caracters")
	@Column(nullable = false)
	private String password;
	
	@JsonIgnore
	@Transient
	private String current_password;
	
	@JsonIgnore
//	@NotBlank(message = "Password confirmation is mandatory")
//	@Size(min = 4, max = 50, message = "Password confirmation length should be betweeen 4 to 50 caracters")
	@Transient
	private String confirm_password;
	
//	@NotEmpty(message = "Type is mandatory")
	@Enumerated(EnumType.STRING)
	private Enum_userType type;
	
//	@NotEmpty(message = "Type is mandatory")
	@Enumerated(EnumType.STRING)
	private Enum_gender gender;
	
	private String photo;
	private boolean active = true;
	
	@Lob
	private String introduction;
	
//	 For teacher
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private Set<Course> list_teacher_courses = new HashSet<>();
	
//	For review
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private Set<Review> list_reviews = new HashSet<>();
	
//	For Admin
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
	private Set<Course> list_admin_courses = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student", 
      joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Course> list_courses;
}
