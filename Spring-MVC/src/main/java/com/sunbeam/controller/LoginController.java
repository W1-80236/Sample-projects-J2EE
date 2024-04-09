package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.pojo.Credentials;
import com.sunbeam.pojo.User;
import com.sunbeam.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String authenticateUser(Credentials cr) {
		User user = userService.authenticate(cr);
		if(user != null)
			return "welcome";
		else
			return "failed";
	}

}
