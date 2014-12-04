package com.staples.search.dao;

public class User {

	private String username;
	private String password;
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
