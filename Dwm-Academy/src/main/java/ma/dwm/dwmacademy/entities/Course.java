package ma.dwm.dwmacademy.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COURSES")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Course extends BaseEntity {
	
	@Column(nullable = false)
	private String title;
	@Lob
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String photo;
	private String duration;
	
	@ManyToOne
	private User admin;
	@ManyToOne
	private Category category;
	@ManyToOne
	private User teacher;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Content> list_contents;
	
	@ManyToMany(mappedBy = "list_courses", fetch = FetchType.EAGER)
    private List<User> list_students;
	
}
