package com.jdc.leaves.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.leaves.model.dto.input.LeaveForm;
import com.jdc.leaves.model.service.ClassService;
import com.jdc.leaves.model.service.LeaveService;
import com.jdc.leaves.model.service.StudentService;

@Controller
@RequestMapping("leaves")
public class LeaveController {
	
	@Autowired
	private LeaveService service;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private StudentService studentService;

	@GetMapping
	public String index(
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Optional<LocalDate> from, 
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Optional<LocalDate> to,
			ModelMap model) {
		model.put("list", service.search(Optional.empty(), from, to));
		return "leaves";
	}

	@GetMapping("edit")
	public String edit(@RequestParam int classId, @RequestParam int studentId, ModelMap model) {
		model.put("classInfo", classService.findInfoById(classId));
		model.put("studentInfo", studentService.findInfoById(studentId));
		return "leaves-edit";
	}

	@PostMapping
	public String save(@Valid @ModelAttribute("form") LeaveForm form, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			model.put("classInfo", classService.findInfoById(form.getClassId()));
			model.put("studentInfo", studentService.findInfoById(form.getStudent()));
			return "leaves-edit";
		}
		
		service.save(form);
		
		return "redirect:/leaves";
	}
	
	@ModelAttribute("form")
	LeaveForm form(@RequestParam(required = false) Integer classId, @RequestParam(required = false) Integer studentId) {
		if(null != classId && null != studentId) {
			var form = new LeaveForm(classId, studentId);
			form.setApplyDate(LocalDate.now());
			return form;
		}
		
		return new LeaveForm();
	}

}