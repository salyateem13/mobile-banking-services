package com.cgbank.customers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgbank.commonservices.Response;


@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	
	@PostMapping("/registration")
	public ResponseEntity <Response> registration (@RequestBody Customer customer ){
		try {
			Customer dbUser = customerService.save(customer);
			if(dbUser != null) {
				return new ResponseEntity<Response>(new Response( "Customer is saved successfully" ), HttpStatus.OK);
			}
			
		}catch(Exception e) {
			
			return new ResponseEntity<Response>(new Response( "Customer save failed due to: " + e), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(new Response( "Customer save failed" ), HttpStatus.NOT_FOUND);
	}
	
}
