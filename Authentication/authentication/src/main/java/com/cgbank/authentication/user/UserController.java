package com.cgbank.authentication.user;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgbank.authentication.UnauthorizedException;
import com.cgbank.authentication.domain.Response;
import com.cgbank.authentication.domain.UserDTO;
import com.cgbank.authentication.security.JwtTokenUtil;
import com.cgbank.authentication.security.JwtUser;


@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired private UserService userService;

	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private JwtTokenUtil jwtTokenUtil;
	
	
	@PostMapping("/registration")
	public ResponseEntity <Response> registration (@RequestBody User user ){
		try {
			User dbUser = userService.save(user);
			if(dbUser != null) {
				return new ResponseEntity<Response>(new Response( "User is saved successfully" ), HttpStatus.OK);
			}
			
		}catch(Exception e) {
			
			return new ResponseEntity<Response>(new Response( "User save failed due to: " + e), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(new Response( "User save failed" ), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/login")
	public ResponseEntity <UserDTO> login (@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), Collections.emptyList()  ) );
			final JwtUser userDetails = (JwtUser)authentication.getPrincipal();
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jwtTokenUtil.generateToken(userDetails, authentication);
			
			response.setHeader("Token", token);
			return new ResponseEntity<UserDTO> (new UserDTO(userDetails.getUser(), token), HttpStatus.OK);
			
		}catch(Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}
	
	
	@RequestMapping("/hello")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	
	
}
