package ma.dwm.dwmacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import ma.dwm.dwmacademy.repositories.ICategoryRepository;
import ma.dwm.dwmacademy.repositories.ICourseRepository;
import ma.dwm.dwmacademy.repositories.IInstructorRepository;

@Controller
@CrossOrigin("*")
public class ApplicationController {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private IInstructorRepository instructorRepository;
	@Autowired
	private ICourseRepository courseRepository;
	
	@GetMapping("/")
	public String getWelcomePage(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("instructors", instructorRepository.findAll());
		model.addAttribute("courses", courseRepository.findAll());
		model.addAttribute("test", "Welcome Sweet Jiji");
		return "index";
	}

}
