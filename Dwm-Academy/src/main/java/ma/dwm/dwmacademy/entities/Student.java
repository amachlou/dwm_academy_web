package ma.dwm.dwmacademy.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STUDENTS")
@Data //@NoArgsConstructor @AllArgsConstructor
public class Student extends User {
	
	@OneToMany(mappedBy = "student")
	private List<Review> list_reviews;
	@OneToMany(mappedBy = "student")
	private List<StudentCourse> list_student_courses;

}
