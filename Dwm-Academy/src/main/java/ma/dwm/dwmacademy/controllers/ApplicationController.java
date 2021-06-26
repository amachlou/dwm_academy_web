package ma.dwm.dwmacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import ma.dwm.dwmacademy.repositories.ICategoryRepository;
import ma.dwm.dwmacademy.repositories.ICourseRepository;
import ma.dwm.dwmacademy.repositories.IUserRepository;
import ma.dwm.dwmacademy.utils.UserType;

@Controller
@CrossOrigin("*")
public class ApplicationController {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ICourseRepository courseRepository;
	
	@GetMapping("/")
	public String getWelcomePage(Model model) {
		model.addAttribute("best_categories", categoryRepository.getBestCategories());
		model.addAttribute("teachers", userRepository.findByType(UserType.TEACHER));
		model.addAttribute("courses", courseRepository.findAll());
		model.addAttribute("test", "Welcome Sweet Jiji");
		return "index";
	}
	
}
