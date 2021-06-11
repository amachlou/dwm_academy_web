package ma.dwm.dwmacademy.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.dwm.dwmacademy.entities.Category;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;

@RestController
//@Controller
@RequestMapping(path = "/api2")
public class CategoryController {
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	@GetMapping(path = "/categories")
	public List<Category> getCategories(Model model){
		model.addAttribute("categories", categoryRepository.findAll());
//		return "view"; //categoryRepository.findAll();
		return categoryRepository.findAll();
	}

}
