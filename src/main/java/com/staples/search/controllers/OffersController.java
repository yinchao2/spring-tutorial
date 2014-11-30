package com.staples.search.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.staples.search.dao.Offer;
import com.staples.search.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		model.addAttribute("offers", offersService.getOffers());
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String creatOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(@Valid Offer offer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "createoffer";
		} 
		
		return "offercreated";
	}

}
