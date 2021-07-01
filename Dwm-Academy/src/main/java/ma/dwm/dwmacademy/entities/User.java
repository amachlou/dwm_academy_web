package ma.dwm.dwmacademy.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dwm.dwmacademy.utils.UserType;

@Entity
@Table(name = "USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {
	
	@NotBlank(message = "First name is mandatory")
	@Size(min = 4, max = 50, message = "First name length should be betweeen 4 to 50 caracters")
	@Column(nullable = false, length = 50)
	private String first_name;
	
	@NotBlank(message = "Last name is mandatory")
	@Size(min = 4, max = 50, message = "Last name length should be betweeen 4 to 50 caracters")
	@Column(nullable = false, length = 50)
	private String last_name;
	
	@NotBlank(message = "Email is mandatory")
	@Size(min = 4, max = 100, message = "First name length should be betweeen 4 to 100 caracters")
	@Email(message = "Email should be valid")
	@Column(nullable = false, length = 100)
	private String email;
	
//	@NotBlank(message = "Date of birth is mandatory")
	@Temporal(TemporalType.DATE)
	private Date date_birth;

	@NotBlank(message = "Password is mandatory")
	@Size(min = 4, max = 50, message = "Password lenth should be betweeen 4 to 50 caracters")
	@Column(nullable = false)
	private String password;
	
	@NotBlank(message = "Password confirmation is mandatory")
	@Size(min = 4, max = 50, message = "Password confirmation length should be betweeen 4 to 50 caracters")
	@Column(nullable = false)
	@Transient
	private String confirm_password;
	
//	@NotEmpty(message = "Type is mandatory")
	@Enumerated
	private UserType type;
	
	private String photo;
	
	// For teacher
	@OneToMany(mappedBy = "teacher")
	private List<Course> list_teacher_courses;
	
//	For Students
	@OneToMany(mappedBy = "student")
	private List<Review> list_reviews;
	@OneToMany(mappedBy = "student")
	private List<StudentCourse> list_student_courses;
	
//	For Admin
	@OneToMany(mappedBy = "admin")
	private List<Course> list_admin_courses;
	
}
