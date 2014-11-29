package com.staples.search.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String creatOffer() {
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Offer offer) {
		System.out.println(offer);
		return "offercreated";
	}

}
