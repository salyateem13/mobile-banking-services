package com.cgbank.accounts.account;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgbank.accounts.account.models.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	ArrayList<Account>findAccountByuserid(Long id);
	

}



