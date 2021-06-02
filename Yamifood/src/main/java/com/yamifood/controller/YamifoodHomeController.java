package com.yamifood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YamifoodHomeController {
	@RequestMapping({"/yamifood","/home"})
	public String showHomePage() {
		return "home";
	}
}
