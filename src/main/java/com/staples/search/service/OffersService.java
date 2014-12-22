package com.staples.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.staples.search.dao.Offer;
import com.staples.search.dao.OffersDao;

@Service("offersService")
public class OffersService {

	private OffersDao offersDao;

	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}
	
	public List<Offer> getOffers() {
		return offersDao.getOffers();
	}
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void saveOrUpdate(Offer offer) {
		offersDao.saveOrUpdate(offer);
	}

	public void throwTestException() {
		offersDao.getOffer(99999);
	}

	public boolean hasOffer(String username) {
		// user does not login
		if(username == null) {
			return false;
		}
		
		List<Offer> offers = offersDao.getOffers(username);
		// user has no offer
		if(offers.size() == 0) {
			return false;
		}
		
		return true;
	}

	public Offer getOffer(String username) {
		
		if(username == null) {
			return null;
		}
		
		List<Offer> offers = offersDao.getOffers(username);
		
		// user has no offer
		if(offers.size() == 0) {
			return null;
		}
		return offers.get(0);
	}

	public void delete(int id) {
		offersDao.delete(id);
	}
}
