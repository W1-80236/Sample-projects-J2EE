package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sunbeam.pojos.Credentials;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;
import com.sunbeam.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String autheticateUser(Credentials cr, HttpSession session) {
		User user = userService.authenticate(cr);
		if(user != null) {
			session.setAttribute("curUser", user);
			return "redirect:allreviews"; 
		}
		return "failed";
	}
	
	@RequestMapping("/register")
	public String newUserRegistration(Model model) {
		User user = new User();
		model.addAttribute("usr", user);
		return "newuser";
	}
	
	@RequestMapping("/saveuser")
	public String saveUser(@Validated @ModelAttribute("usr") User user, BindingResult res) {
		if(res.hasErrors()) {
			System.out.println(res);
			return "newuser";
		} 
		else { 
			int count = userService.saveUser(user);
		}
		return "redirect:/";
	}
	@RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
         return "index";       
   }
	
	@RequestMapping("/changepassword")
	public String editPassword() {
		return "password";
	}
	
	
	@RequestMapping("/updatepassword")
	public String updatePassword(Credentials cr, HttpSession session) {
		User user = (User)session.getAttribute("curUser");
		int userId=user.getId();
		int count = userService.editPassword(cr,userId);
		return "index";
	}
	
		
}
