package ma.dwm.dwmacademy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.dwm.dwmacademy.entities.Category;
import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;
import ma.dwm.dwmacademy.repositories.ICourseRepository;
import ma.dwm.dwmacademy.repositories.IUserRepository;

@SpringBootApplication
@EnableJpaRepositories("ma.dwm.dwmacademy.repositories")
public class DwmAcademyApplication implements CommandLineRunner {

	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	ICourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DwmAcademyApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		Category cat_machineLearning = new Category("Machine learning", null, null);
//		Category cat_english = new Category("English", null, null);
//		Category cat_ia = new Category("IA", null, null);
//		Category cat_webTechnologies = new Category("Web technologies", null, null);
//		Category cat_softSkills = new Category("Soft skills", null, null);
//		Category cat_bigData = new Category("Big Datag", null, null);
//		Category cat_science = new Category("Science", null, null);
//		
//		categoryRepository.save(cat_machineLearning);
//		categoryRepository.save(cat_english);
//		categoryRepository.save(cat_ia);
//		categoryRepository.save(cat_webTechnologies);
//		categoryRepository.save(cat_softSkills);
//		categoryRepository.save(cat_bigData);
//		categoryRepository.save(cat_science);
		
//		courseRepository.save(new Course("UML for dummies", "UML for dummies 101", new Date(), null, null, cat_science, null, null, null);

//		Course(String, String, Date, String, User, Category, User, List<Content>, Set<User>);
//		Course(String, String, Date, String, User, Category, User, List<Content>, );
		
		String password = new BCryptPasswordEncoder().encode("01");
//		Teacher
		
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "Java Developer", new Date(), password, null, null, Enum_userType.ADMIN, enum_gender.MALE, true, null, null, null, null, null));
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "123456", "TEACHER", null, null, null, null, null));
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "123456", "TEACHER", null, null, null, null, null));
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "123456", "TEACHER", null, null, null, null, null));

//		User u1 = new User(password, password, password, password, null, password, password, password, null, null, password, false, password, null, null, null, null);
//		"$2a$10$tQSejRVjxWWHBZN0h1.G/OiZKvCpYNjmkuVUKR106YA8Dqfo0UOHS"
//		userRepository.save(new User("Ahmed", "Hassnaoui", "mail@mail.com", "Web analyst", null, password, password, password, null, null, password, false, password, null, null, null, null));
//		userRepository.save(new User("Fatima", "Raachid", "mail@mail.com", "Economics expert", null, password, password, password, null, null, password, false, password, null, null, null, null));
//		userRepository.save(new User("Jihane", "Arfi", "mail@mail.com", "Web analyst", null, password, password, password, null, null, password, false, password, null, null, null, null));
////		userRepository.save(new User("Aziz", "Daif", "mail@mail.com", "", "Web analyst", password, password, password, null, null, password, false, password, null, null, null, null));
//		userRepository.save(new User("Yussra", "Hassani", "mail@mail.com", "Technical exppert", null, password, password, password, null, null, password, false, password, null, null, null, null));
//		userRepository.save(new User("Abderrahim", "Machlou", "mail@mail.com", "Java developer", null, password, password, password, null, null, password, false, password, null, null, null, null));
		
		

	}

}
