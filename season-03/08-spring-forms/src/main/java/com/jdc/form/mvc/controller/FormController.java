package com.jdc.form.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.form.mvc.validator.UserInputValidator;
import com.jdc.form.root.dto.Course;
import com.jdc.form.root.dto.UserInput;
import com.jdc.form.root.dto.UserInput.Gender;
import com.jdc.form.root.service.CourseRepository;
import com.jdc.form.root.service.DataHolder;

@Controller
@RequestMapping("form")
public class FormController {
	
	@Autowired
	private DataHolder repo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private UserInputValidator userInputValidator;

	@InitBinder
	void initWebBinder(WebDataBinder binder) {
		binder.addValidators(userInputValidator);
	}
		
	@GetMapping
	void index() {
	}
	
	@PostMapping
	String create(@Valid @ModelAttribute("userInput") UserInput data, BindingResult result) {
		
		if(result.hasErrors()) {
			return "form";
		}
		
		repo.add(data);
		return "redirect:/form";
	}
	
	@ModelAttribute("courses")
	List<Course> courses() {
		return courseRepo.getCourses();
	}
	
	@ModelAttribute("userInput")
	UserInput userInput() {
		return new UserInput();
	}
	
	@ModelAttribute("list")
	List<UserInput> allData() {
		return repo.getAllData();
	}
	
	@ModelAttribute("genders")
	Gender[] genders() {
		return Gender.values();
	}
	
	@ModelAttribute("knowledges")
	List<String> foundations() {
		return List.of("HTML", "CSS", "JavaScropt", "Database");
	}
}
