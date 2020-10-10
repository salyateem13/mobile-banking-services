package com.cgbank.authentication.user;

import java.util.List;


public interface UserService {
	
	User save(User user) ;

	List<User> findAll();

	User getUserByUsername(String name);

}
