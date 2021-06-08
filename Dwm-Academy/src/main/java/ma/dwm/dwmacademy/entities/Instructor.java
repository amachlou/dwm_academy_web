package ma.dwm.dwmacademy.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "INSTRUCTORS")
@Data //@NoArgsConstructor @AllArgsConstructor
public class Instructor extends User {
	
	@OneToMany(mappedBy = "instructor")
	private List<Course> list_courses;

}
