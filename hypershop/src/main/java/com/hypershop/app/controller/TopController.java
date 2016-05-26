package com.hypershop.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {
	
	private static final Logger logger = LoggerFactory.getLogger(TopController.class);
	
	@RequestMapping("/")
	public String init(Model model){
		String message = "hello world!";
		model.addAttribute("message", message);
		logger.info("log test!");
		return "index";
	}
}
