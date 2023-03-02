package com.rabbitink.rabbitink.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexContoller {
	@GetMapping("/")
	public String welcomeRedirect() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/welcome")
	public String getAbout() {
		return "welcome";
	}

	@GetMapping("/team")
	public String getTeam() {
		return "team";
	}

	@GetMapping("/services")
	public String getServices() {
		return "services";
	}

	@GetMapping("/works")
	public String getWorks() {
		return "works";
	}

	@GetMapping("/contact")
	public String getContact() {
		return "contact";
	}
}
