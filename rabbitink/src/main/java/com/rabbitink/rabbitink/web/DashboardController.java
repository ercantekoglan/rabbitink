package com.rabbitink.rabbitink.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.rabbitink.rabbitink.domain.User;
import com.rabbitink.rabbitink.service.DashboardService;

@Controller
public class DashboardController {
	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/dashboard")
	public String getDashboard(ModelMap model) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long id = loggedInUser.getId();
		model.put("orders", dashboardService.findAllByUserId(loggedInUser.getId()));
		return "dashboard";
	}
}