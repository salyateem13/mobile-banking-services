package com.cgbank.accounts.account.models;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "MONEYMARKET")
public class MoneyMarketAccount extends Account{

	public MoneyMarketAccount(int id, String name, Long balance, Long apr, Long minBalance, Long userid, Boolean isAuthorized, Boolean is_auth) {
		super(id, name, balance, apr, minBalance, userid, isAuthorized,  is_auth);
		// TODO Auto-generated constructor stub
	}

}
