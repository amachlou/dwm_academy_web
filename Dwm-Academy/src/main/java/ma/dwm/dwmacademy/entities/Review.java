package ma.dwm.dwmacademy.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "REVIEWS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Review extends BaseEntity {
	
	@Lob
	private String content;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToOne
	private User student;
	
}
