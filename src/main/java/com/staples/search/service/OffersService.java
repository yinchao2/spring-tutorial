package com.staples.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public void create(Offer offer) {
		offersDao.create(offer);
	}

	public void throwTestException() {
		offersDao.getOffer(99999);
	}
}
