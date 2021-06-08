package ma.dwm.dwmacademy.entities;

import java.util.Date;

import javax.persistence.Column;

public class User extends BaseEntity {
	
	@Column(nullable = false, length = 50)
	private String first_name;
	@Column(nullable = false, length = 50)
	private String last_name;
	@Column(nullable = false, length = 100)
	private String email;
	private Date date_birth;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, length = 25)
	private String tyle;

}
