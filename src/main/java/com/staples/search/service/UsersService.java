package com.staples.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.staples.search.dao.Message;
import com.staples.search.dao.MessagesDao;
import com.staples.search.dao.User;
import com.staples.search.dao.UsersDao;

@Service("usersService")
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private MessagesDao messagesDao;
	
	public void create(User user) {
		usersDao.create(user);
	}
	
	public boolean exists(String username) {
		return usersDao.exists(username);
	}
	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
	
	public void sendMessage(Message message) {
		messagesDao.saveOrUpdate(message);
	}
	
	public User getUser(String username) {
		return usersDao.getUser(username);
	}
	
	public List<Message> getMessages(String username) {
		System.out.println("username: " + username);
		return messagesDao.getMessages(username);
	}
	
}
