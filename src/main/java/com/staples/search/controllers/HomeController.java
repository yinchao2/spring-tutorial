package com.staples.search.controllers;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staples.search.dao.Offer;
import com.staples.search.service.OffersService;

@Controller
public class HomeController {
	
	@Autowired
	private OffersService offersService;

	private static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {
		
		boolean hasOffer = false;
		
		if(principal != null) {
			String username = principal.getName();
			
			hasOffer = offersService.hasOffer(username);
		}
		
		model.addAttribute("hasOffer", hasOffer);
		model.addAttribute("offers", offersService.getOffers());
		
		return "home";
	}

}
