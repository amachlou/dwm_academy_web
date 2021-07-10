package ma.dwm.dwmacademy.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTENTS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Content extends BaseEntity {
	
	@Column(nullable = false)
	private String title;
	@Lob
	@Column(nullable = false)
	private String source;
	@Temporal(TemporalType.DATE)
	private Date duration;
	
	@ManyToOne
	private Course course;
}
