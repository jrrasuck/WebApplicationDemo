package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET) // this is a path
//	@ResponseBody //Go directly to the screen
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) // this is a path
	public String handleLogRequest(@RequestParam String name, 
			@RequestParam String password,
			ModelMap model) {

		if (!service.isUserValid(name, password)) {
			model.put("errorMessage", "Invalid Credentials - Spring MVC");
			return "login";
		}
		model.put("name", name);
		return "welcome";
	}

}