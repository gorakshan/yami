package com.yamifood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	@RequestMapping("/menu")
	public String showMenu() {
		return "menu";
	}

	@RequestMapping("/about")
	public String aboutMenu() {
		return "about";
	}

	@RequestMapping("/reservation")
	public String reservationMenu() {
		return "reservation";
	}

	@RequestMapping("/stuff")
	public String stuffMenu() {
		return "stuff";
	}

}
