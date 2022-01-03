package com.jdc.book.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.book.root.service.FileUploadService;

@Controller
@RequestMapping("upload")
public class BookUploadController {
	
	@Autowired
	private FileUploadService service;

	@PostMapping
	String upload(
			@RequestParam("uploadFile") MultipartFile partFile,
			RedirectAttributes redirect) {
		
		if(null != partFile && !partFile.isEmpty()) {
			var message = service.upload(partFile);
			redirect.addFlashAttribute("uploadMessage", message);
			return "redirect:/home";
		}
		
		return "home";
	}
}
