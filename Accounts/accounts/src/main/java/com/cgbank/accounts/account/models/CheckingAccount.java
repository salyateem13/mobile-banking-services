package com.cgbank.accounts.account.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value = "CHECKING")
public class CheckingAccount extends Account{

	public CheckingAccount () {
		super();
	}
	public CheckingAccount(int id, String name, Long balance, Long apr, Long minBalance, Long userid, Boolean isAuthorized, Boolean is_auth) {
		super(id, name, balance, apr, userid, minBalance, isAuthorized,  is_auth);
		// TODO Auto-generated constructor stub

	
	}

}
