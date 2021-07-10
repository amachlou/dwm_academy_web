package ma.dwm.dwmacademy.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CATEGORIES")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Category extends BaseEntity {
	
	@Column(nullable = false)
	private String name;
	private String photo;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Course> list_courses = new HashSet<>();
	
}
