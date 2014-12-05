package com.staples.search.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.staples.search.validation.ValidEmail;

public class User {

	@NotBlank(message="Username cannot be blank.")
	@Size(min=8, max=15, message="Username must be between 8 and 15 characters long.")
	@Pattern(regexp="^\\w{8,}$", message="Username can only consist of numbers, letters and the underscore character.")
	private String username;
	@NotBlank(message="Password cannot be blank.")
	@Pattern(regexp="^\\S+$", message="Password cannot contain spaces.")
	@Size(min=8, max=15, message="Password must be between 8 and 15 characters long.")
	private String password;
	@ValidEmail(message="This does not appear to be a valid email address.")
	private String email;
	private String authority;
	private boolean enabled = false;

	public User() {

	}

	public User(String username, String password, String email,
			String authority, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.authority = authority;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
