package com.cgbank.accounts.account.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CDIRA")
public class CDIRAAccount extends Account {

	public CDIRAAccount(int id, String name, Long balance, Long apr, Long minBalance, Long userid, Boolean isAuthorized, Boolean is_auth) {
		super(id, name, balance, apr, minBalance, userid, isAuthorized,  is_auth);
		// TODO Auto-generated constructor stub
	}

}
