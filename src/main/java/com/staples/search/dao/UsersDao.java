package com.staples.search.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("usersDao")
public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}
	
	// check if username already exist
	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("FROM Userrr").list();
		//return jdbc.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(User.class));
	}
}
