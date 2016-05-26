package com.hypershop.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {
	
	@RequestMapping("/top")
	public String init(Model model){
		String message = "hello world!";
		model.addAttribute("message", message);
		return "index";
	}
}
