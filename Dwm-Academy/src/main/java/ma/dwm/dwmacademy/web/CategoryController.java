package ma.dwm.dwmacademy.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.dwm.dwmacademy.entities.Category;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;

@RestController
@RequestMapping(path = "/api2")
public class CategoryController {
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	@GetMapping(path = "/categories")
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}

}
