package com.staples.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staples.search.dao.User;
import com.staples.search.dao.UsersDao;

@Service("usersService")
public class UsersService {

	private UsersDao usersDao;

	@Autowired
	public void setOffersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public void create(User user) {
		usersDao.create(user);
	}
	
	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
	
}
