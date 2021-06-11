package ma.dwm.dwmacademy.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CATEGORIES")
@Data @NoArgsConstructor @AllArgsConstructor //@EqualsAndHashCode(callSuper=false)
public class Category extends BaseEntity {
	
	@Column(nullable = false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Course> list_courses;
	
}
