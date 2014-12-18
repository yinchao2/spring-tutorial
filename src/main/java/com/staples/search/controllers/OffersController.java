package com.staples.search.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.staples.search.dao.Offer;
import com.staples.search.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
//	@ExceptionHandler(DataAccessException.class)
//	public String handleDatabaseException(DataAccessException ex) {
//		return "error";
//	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		//offersService.throwTestException();
		
		model.addAttribute("offers", offersService.getOffers());
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String creatOffer(Model model, Principal principal) {
		
		Offer offer = null;
		// if you has offer, get text and place it in edit form
		if(principal != null) {
			String username = principal.getName();
			
			offer = offersService.getOffer(username);
		}
		
		if(offer == null) {
			offer = new Offer();
		}
		
		model.addAttribute("offer", offer);
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(@Valid Offer offer, @RequestParam(value="delete", required=false) String delete, BindingResult result, Principal principal) {
		
		if(result.hasErrors()) {
			return "createoffer";
		}
		
		if(delete != null) {
			offersService.delete(offer.getId());
			return "offerdeleted";
		} else {

			String username = principal.getName();
			offer.getUser().setUsername(username);
			
			offersService.saveOrUpdate(offer);
			
			return "offercreated";	
		}
	}
}
