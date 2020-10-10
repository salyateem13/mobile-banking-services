package com.cgbank.accounts.account;

import java.util.ArrayList;

import com.cgbank.accounts.account.models.Account;

public interface AccountService {
	Account save(Account account);
	ArrayList<Account> findAccountsByUserid(Long userId);
}
