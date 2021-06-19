package ma.dwm.dwmacademy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.dwm.dwmacademy.entities.Category;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;

@SpringBootApplication
public class DwmAcademyApplication implements CommandLineRunner {
	
	@Autowired
	ICategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DwmAcademyApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));
//		categoryRepository.save(new Category("AAA", null));

	}

}
