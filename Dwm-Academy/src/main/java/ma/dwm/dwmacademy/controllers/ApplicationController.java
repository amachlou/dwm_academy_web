package ma.dwm.dwmacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ma.dwm.dwmacademy.entities.User;
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
	public String getWelcomePage(ModelMap model, User user) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("best_categories", categoryRepository.getBestCategories());
		model.addAttribute("teachers", userRepository.findByType(UserType.TEACHER));
		model.addAttribute("courses", courseRepository.findAll());
		model.addAttribute("test", "Welcome Sweet Jiji");
		model.addAttribute("user", user);
		return "redirect:/users/signup";
	}
	
	@GetMapping("/test/{uri}")
	public String testPage(@PathVariable("uri") String uri, ModelMap model) {
		model.addAttribute("best_categories", categoryRepository.getBestCategories());
		return uri;
	}
	
}
