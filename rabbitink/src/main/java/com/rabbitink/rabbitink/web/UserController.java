package com.rabbitink.rabbitink.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/login")
  public String login () {
    return "login";
  }
  
  @GetMapping("/dashboard")
  public String getDashboard () {
    return "dashboard";
  }
  @GetMapping("/register")
  public String getRegister () {
    return "register";
  }
}
