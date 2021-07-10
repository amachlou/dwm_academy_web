package ma.dwm.dwmacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;
import ma.dwm.dwmacademy.repositories.ICourseRepository;
import ma.dwm.dwmacademy.repositories.IUserRepository;
import ma.dwm.dwmacademy.utils.Enum_userType;

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
//		model.addAttribute("categories", categoryRepository.findAll());
//		model.addAttribute("best_categories", categoryRepository.getBestCategories());
//		model.addAttribute("teachers", userRepository.findByType(UserType.TEACHER));
//		model.addAttribute("courses", courseRepository.findAll());
		model.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping("/test/{uri}")
	public String testPage(@PathVariable("uri") String uri, ModelMap model) {
		return uri;
	}
	
//	@GetMapping("error")
//	public String error(Model model) {
//		return "error";
//	}
//	
//	@GetMapping("403")
//	public String error403(ModelMap model) {
//		return "403";
//	}
	
	@ModelAttribute
	public void addAttributes(Model model, User user) {
//		 @AuthenticationPrincipal
		model.addAttribute("user", userRepository.findByType(Enum_userType.ADMIN).get(0));
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("best_categories", categoryRepository.getCategoriesPage(PageRequest.of(0, 3)));
		model.addAttribute("teachers", userRepository.findByType(Enum_userType.TEACHER));
		model.addAttribute("courses", courseRepository.findAll());
	}
	
}
