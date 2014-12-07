package com.staples.search.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.staples.search.dao.User;
import com.staples.search.service.UsersService;

@Controller
public class LoginController {
	
	private UsersService userService;
	
	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "admin";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newaccount";
		}
		// check if username already exist
		if(userService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		userService.create(user);
		
		return "accountcreated";	
	}
}
