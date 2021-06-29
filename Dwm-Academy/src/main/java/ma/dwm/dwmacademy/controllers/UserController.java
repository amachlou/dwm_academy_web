package ma.dwm.dwmacademy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.dwm.dwmacademy.entities.User;
import ma.dwm.dwmacademy.repositories.IUserRepository;


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
//	ddd
	@GetMapping("/{id}")
	public String getOne(@PathVariable("id") long id, Model model){
		model.addAttribute("user", userRepository.findById(id));
		return "";
	}
	
	@PostMapping("/web/signup")
	public String signup(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user-form";
		}
		
		userRepository.save(user);
		return getAll(model);
	}
	
	@PostMapping("/web/signin")
	public String signin(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user-form";
		}
		
		userRepository.save(user);
		return getAll(model);
	}
	
	@GetMapping("/web/edit/{id}")
	public String init_update(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("user", user);
		return "update-user";
	}
	
	@PostMapping("/web/update")
	public String update(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-user";
		}
		
		userRepository.save(user);
		return getAll(model);//"redirect:";
	}
	
	@GetMapping("/web/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	    User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    userRepository.delete(user);
	    return getAll(model);
	}

}
