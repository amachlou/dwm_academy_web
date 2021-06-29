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

import ma.dwm.dwmacademy.entities.Course;
import ma.dwm.dwmacademy.repositories.ICourseRepository;


@Controller
@RequestMapping(path = "/web/courses")
public class CourseController {
	
	@Autowired
	private ICourseRepository courseRepository;
	
	@GetMapping("/courses")
	public String getAll(Model model){
		model.addAttribute("courses", courseRepository.findAll());
		return "course-overview";
	}
	
	@GetMapping("/{id}")
	public String getOne(@PathVariable("id") long id, Model model){
		model.addAttribute("course", courseRepository.findById(id));
		return "";
	}
	
	@GetMapping("/edit/{id}")
	public String init_update(@PathVariable("id") long id, Model model) {
		Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
		model.addAttribute("course", course);
		return "update-course";
	}
	
	@PostMapping("/update")
	public String update(@Valid Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-course";
		}
		
		courseRepository.save(course);
		return getAll(model);//"redirect:";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	    Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
	    courseRepository.delete(course);
	    return getAll(model);
	}

}
