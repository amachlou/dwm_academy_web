package ma.dwm.dwmacademy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ma.dwm.dwmacademy.entities.Course;
import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;
import ma.dwm.dwmacademy.repositories.ICourseRepository;
import ma.dwm.dwmacademy.repositories.IUserRepository;
import ma.dwm.dwmacademy.utils.Enum_userType;


@Controller
@RequestMapping(path = "/web/users")
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
//		model.addAttribute("user", userRepository.findById(id));
		// For demonstration
		User user = userRepository.findByType(Enum_userType.ADMIN).get(0);
		model.addAttribute("target", target);
		
		if(user != null) {
			return user.getType().toString().toLowerCase()+"-dashboard";
		} else {
			return "index";
		}
	}

	@GetMapping("/home")
//	@GetMapping("/home/{id}")
	public String home(/*@PathVariable long id,*/ Model model){
//		User user = userRepository.findById(id).get();
		return "home";
	}
	
	@GetMapping("/signup")
	public String int_signup(@RequestParam(defaultValue = "") String target, User user, Model model) {
		model.addAttribute("target", Enum_userType.TEACHER);
		model.addAttribute("user_types", Enum_userType.values());
		model.addAttribute("categories", categoyRepository.findAll());
		return "user-form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid User user, BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			model.addAttribute("user", user);
//			model.addAttribute("user_types", UserType.values());
//			return "user-form";
//		}
		try {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
		} catch (Exception e) {
//			return new ModelAndView("redirect:/signup");
			return "user-form";
		}
//		return new ModelAndView("redirect:/web/users/signin");
		return "home";
	}
	
	@GetMapping("/signin")
	public String int_signin(User user, Model model) {
		return "user-form";
	}
	
	@PostMapping("/signin")
	public ModelAndView signin(User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return new ModelAndView("redirect:");
		}
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));;
		
		return new ModelAndView("redirect:/web/users/home", model);
	}
	
	@PostMapping("/logout")
	public String update() {
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String init_update(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
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
	
	@GetMapping("/{user_id}/courses/{course_id}/add")
	public String addCourse(@PathVariable("user_id") long user_id, @PathVariable("course_id") long course_id, Model model) {
	    User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + user_id));
	    Course course = courseRepository.findById(course_id).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + course_id));
	    user.getList_courses().add(course);
	    userRepository.save(user);
	    return getAll(model);
	}
	
	@GetMapping("/{user_id}/courses")
	public String getCourses(@PathVariable("user_id") long user_id, Model model) {
	    User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + user_id));
	    model.addAttribute("courses", user.getList_courses());
	    return user.getType().toString().toLowerCase()+"-dashboard";
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("best_categories", categoryRepository.getBestCategories());
		model.addAttribute("teachers", userRepository.findByType(Enum_userType.TEACHER));
		model.addAttribute("courses", courseRepository.findAll());
		model.addAttribute("user_types", Enum_userType.values());
		model.addAttribute("user", userRepository.findByType(Enum_userType.ADMIN).get(0)); // TODO For testing
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
