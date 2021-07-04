package ma.dwm.dwmacademy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.dwm.dwmacademy.entities.Category;
import ma.dwm.dwmacademy.repositories.ICategoryRepository;


@Controller
@RequestMapping(path = "/categories")
public class CategoryController {
	
	@Autowired
	private ICategoryRepository categoryRepository;

	@GetMapping
	public String getAll(Model model){
		List<Category> list_categories = new ArrayList<>();
		list_categories = categoryRepository.findAll();
		model.addAttribute("categories", list_categories);
		model.addAttribute("current_category", list_categories.get(0));
		return "category-page";
	}
	
	@GetMapping("/{id}")
	public String getOne(@PathVariable("id") long id, Model model){
		Optional<Category> current_category = categoryRepository.findById(id);
//		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("current_category", categoryRepository.findById(id).get());
//		model.addAttribute("list_courses", current_category.get().getList_courses());
		return "category-page";
	}
	
	@GetMapping("/edit/{id}")
	public String init_update(@PathVariable("id") long id, Model model) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
		model.addAttribute("category", category);
		return "update-category";
	}
	
	@PostMapping("/update")
	public String update(@Valid Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-category";
		}
		
		categoryRepository.save(category);
		return getAll(model);//"redirect:";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	    Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
	    categoryRepository.delete(category);
	    return getAll(model);
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("best_categories", categoryRepository.getBestCategories());
	}

}
