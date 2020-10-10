package com.cgbank.accounts.account;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgbank.accounts.account.models.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired AccountRepository accountRepository;
	
	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public ArrayList<Account> findAccountsByUserid(Long userId) {
		// TODO Auto-generated method stub
		return accountRepository.findAccountByuserid(userId);
	}
	

}
