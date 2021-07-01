package ma.dwm.dwmacademy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.IUserRepository;
import ma.dwm.dwmacademy.utils.UserType;


@Controller
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private IUserRepository userRepository;
	
	@GetMapping
	public String getAll(Model model){
		model.addAttribute("users", userRepository.findAll());
		return "";
	}
	
	@GetMapping("/{id}")
	public String getOne(@PathVariable("id") long id, Model model){
		model.addAttribute("user", userRepository.findById(id));
		return "";
	}
	
	@GetMapping("/signup")
	public String signup(User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("user_types", UserType.values());
		return "user-form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user-form";
		}
		
		userRepository.save(user);
		return getAll(model);
	}
	
	@GetMapping("/signin")
	public String init_signin(User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("user_types", UserType.values());
		return "user-form";
	}
	
	@PostMapping("/signin")
	public String signin(@Valid User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "user-form";
		}
		
		userRepository.save(user);
		return "";// getAll(model);
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
