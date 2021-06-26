package ma.dwm.dwmacademy.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.dwm.dwmacademy.utils.UserType;

@Entity
@Table(name = "USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {
	
	@Column(nullable = false, length = 50)
	private String first_name;
	@Column(nullable = false, length = 50)
	private String last_name;
	@Column(nullable = false, length = 100)
	private String email;
	private Date date_birth;
	@Column(nullable = false)
	private String password;
	@Enumerated
	private UserType type;
	
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
