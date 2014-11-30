package com.staples.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staples.search.dao.Offer;
import com.staples.search.dao.OffersDAO;

@Service("offersService")
public class OffersService {

	private OffersDAO offersDao;

	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}
	
	public List<Offer> getOffers() {
		return offersDao.getOffers();
	}
}
