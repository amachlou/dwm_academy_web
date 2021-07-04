package ma.dwm.dwmacademy.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CATEGORIES")
@Data @NoArgsConstructor @AllArgsConstructor
public class Category extends BaseEntity {
	
	@Column(nullable = false)
	private String name;
	private String photo;
	
	@OneToMany(mappedBy = "category")
	private Set<Course> list_courses = new HashSet<>();
	
}
