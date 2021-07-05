package ma.dwm.dwmacademy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;
import ma.dwm.dwmacademy.repositories.ICourseRepository;
import ma.dwm.dwmacademy.repositories.IUserRepository;
import ma.dwm.dwmacademy.utils.UserType;


@Controller
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ICategoryRepository categoyRepository;
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private ICourseRepository courseRepository;
	
	@GetMapping
	public String getAll(Model model){
		model.addAttribute("users", userRepository.findAll());
		return "";
	}
	
	@GetMapping("/{id}")
	public String getOne(@PathVariable("id") long id, @RequestParam(defaultValue = "") String target,  Model model){
		model.addAttribute("user", userRepository.findById(id));
		model.addAttribute("target", target);
		return "";
	}
	
	@GetMapping("/home_")
	public String home(@AuthenticationPrincipal User user, Model model){
		model.addAttribute("user", user);
		return "home";
	}
	
	@GetMapping("/home")
	public String dash(@AuthenticationPrincipal User user, Model model){
		model.addAttribute("user", user);
		if(user.getType().toString().equals(UserType.ADMIN.toString())) {
			return "admin-dashboard";
		} else if(user.getType().toString().equals(UserType.TEACHER.toString())) {
			return "teacher-dashboard";
		} else if(user.getType().toString().equals(UserType.STUDENT.toString())){
			return "student-dashboard";
		} else {
			return "index";
		}
	}
	
	@GetMapping("/signup")
	public String int_signup(@RequestParam(defaultValue = "") String target, User user, Model model) {
		model.addAttribute("target", UserType.TEACHER);
		model.addAttribute("user", user);
		model.addAttribute("user_types", UserType.values());
		model.addAttribute("categories", categoyRepository.findAll());
		return "user-form";
	}
	
	@PostMapping("/signup")
	public ModelAndView signup(@Valid User user, BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			model.addAttribute("user", user);
//			model.addAttribute("user_types", UserType.values());
//			return "user-form";
//		}
		try {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
		} catch (Exception e) {
			return new ModelAndView("redirect:/signup");
		}
		
		return new ModelAndView("redirect:/", model);
	}
	
	@GetMapping("/signin")
	public String int_signin(User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("user_types", UserType.values());
		return "user-form";
	}
	
	@PostMapping("/signin")
	public ModelAndView signin(User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return new ModelAndView("redirect:");
		}
		
		userRepository.save(user);
		return new ModelAndView("redirect:/home", model);
	}
	
	@GetMapping("/edit/{id}")
	public String init_update(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("user", user);
		return "update-user";
	}
	
	@PostMapping("/update")
	public String update(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-user";
		}
		
		userRepository.save(user);
		return getAll(model);//"redirect:";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	    User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    userRepository.delete(user);
	    return getAll(model);
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("best_categories", categoryRepository.getBestCategories());
		model.addAttribute("teachers", userRepository.findByType(UserType.TEACHER));
		model.addAttribute("courses", courseRepository.findAll());
	}
	
	
	
	
	
	
	

//    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
//    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
//        Product p = productRepository.findById(id).get();
//        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));
//    }
//    @PostMapping(path = "/uploadPhoto/{id}")
//    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
//       Product p = productRepository.findById(id).get();
//       p.setPhotoName(file.getOriginalFilename());
//       Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()),file.getBytes());
//       productRepository.save(p);
//    }
    
    
    
    
    
    
    

}
