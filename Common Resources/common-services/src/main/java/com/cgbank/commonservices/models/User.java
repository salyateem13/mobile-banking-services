package com.cgbank.commonservices.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.validation.constraints.NotNull;



public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3009157732242241606L;

	
	private Long id;
	
	
	private String username;
	
	
	private String password;
	

	private String email;
	
	

	

	public User() {
		super();
	}

	public User(Long id, @NotNull String username, String password,
			String email) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.username = username;
	}


	public Long getId() {
		return id;
	}




	public String getPassword() {
		return password;
	}



	public String getUsername() {
		return username;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public void setPassword(String password) {
		this.password = password;
	}


	

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
