package ma.dwm.dwmacademy.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COURSES")
@Data @NoArgsConstructor @AllArgsConstructor
public class Course extends BaseEntity {
	
	@Column(nullable = false)
	private String title;
	@Lob
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private User admin;
	@OneToMany(mappedBy = "course")
	private List<Content> list_contents;
	@ManyToOne
	private Category category;
	@ManyToOne
	private User teacher;
	
	@OneToMany(mappedBy = "course")
	private List<StudentCourse> list_student_courses;
	
}
