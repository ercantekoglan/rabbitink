package com.rabbitink.rabbitink.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rabbitink.rabbitink.domain.User;
import com.rabbitink.rabbitink.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;



	@GetMapping("/login")
	public String login(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/dashboard";
	}
	


	// if registered - redirect to display register page
	@GetMapping("/register")
	public String getRegister(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.put("user", new User());
			return "register";
		}
		return "redirect:/login";
	}

	// create new user
	@PostMapping("/register")
	public String postCreateUser(User user) {
		userService.saveUser(user);
		return "redirect:/login";
	}

	@GetMapping("/profile")
	public String getProfile(ModelMap model) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findById(loggedInUser.getId());
		model.put("user", user);
		return "/profile";
	}

}
