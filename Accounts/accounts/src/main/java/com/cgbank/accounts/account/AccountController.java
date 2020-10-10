package com.cgbank.accounts.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgbank.accounts.Response;
import com.cgbank.accounts.account.models.Account;



@RestController
@RequestMapping("/")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/")
	public ResponseEntity <Response> registration (@RequestBody Account account ){
		try {
			Account dbUser = accountService.save(account);
			if(dbUser != null) {
				return new ResponseEntity<Response>(new Response( "Customer is saved successfully" ), HttpStatus.OK);
			}
			
		}catch(Exception e) {
			
			return new ResponseEntity<Response>(new Response( "Customer save failed due to: " + e), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(new Response( "Customer save failed" ), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <List<Account>> getAccounts(@PathVariable Long id){
		List <Account> accounts = accountService.findAccountsByUserid(id);
		
		if (accounts != null) {
			return new ResponseEntity<List<Account>> (accounts, HttpStatus.OK);
		}
		return null;
	}
	
}

