package com.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.authentication.entities.UserLoginData;
import com.authentication.entities.Users;
import com.authentication.services.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	UsersService service;
	
	@GetMapping("/openSignup")
	public String opensignUp() {
		return "sign_up";
	}
	@GetMapping("/openSignin")
	public String opensignIn() {
		return "sign_in";
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute Users user,Model m) {
		String username=user.getUsername();
		boolean usernameExist=service.usernameExist(username);
		if(usernameExist==false) {
		service.addUser(user);
		m.addAttribute("msg","user registered successfully!...");
		return "sign_in";
		}else{
			m.addAttribute("msg","user already exist!...");
			return "sign_up";	
		}
	}
	@PostMapping("/signIn")
	public String signIn(@ModelAttribute UserLoginData data ,Model m) {
		Users existingUser=service.getUserByName(data.getUsername());
		if(existingUser!=null&& data.getPassword().equals(existingUser.getPassword()))
		return "success";
		else {
			m.addAttribute("errorMsg","wrong credentials!...");
			return "sign_in";
		}
		
	}
}
