package ma.dwm.dwmacademy.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STUDENTS_COURSES")
@Data //@NoArgsConstructor @AllArgsConstructor
public class StudentCourse extends BaseEntity {

	@ManyToOne
	private User student;
	@ManyToOne
	private Course course;

}
