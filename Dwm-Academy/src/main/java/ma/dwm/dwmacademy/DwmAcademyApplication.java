package ma.dwm.dwmacademy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.dwm.dwmacademy.entities.Category;
import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;
import ma.dwm.dwmacademy.repositories.IUserRepository;

@SpringBootApplication
public class DwmAcademyApplication implements CommandLineRunner {

	@Autowired
	ICategoryRepository categoryRepository;
	@Autowired
	IUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DwmAcademyApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

//		categoryRepository.save(new Category("IA", null, null));
//		categoryRepository.save(new Category("Machine learning", null, null));
//		categoryRepository.save(new Category("English1", null, null));
//		categoryRepository.save(new Category("Machine learning", null, null));
//		categoryRepository.save(new Category("Web technologies", null, null));
//		categoryRepository.save(new Category("Machine learning", null, null));
//		categoryRepository.save(new Category("Science", null, null));
		
//		Teacher
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "123456", "TEACHER", null, null, null, null, null));
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "123456", "TEACHER", null, null, null, null, null));
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "123456", "TEACHER", null, null, null, null, null));
//		userRepository.save(new User("Abderrahim", "Machlou", "amachlou@dwm.ma", "123456", "TEACHER", null, null, null, null, null));
		
		

	}

}
