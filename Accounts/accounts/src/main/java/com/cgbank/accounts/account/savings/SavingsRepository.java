package com.cgbank.accounts.account.savings;

import org.springframework.data.repository.CrudRepository;

import com.cgbank.accounts.account.models.SavingsAccount;

public interface SavingsRepository extends CrudRepository<SavingsAccount, Long> {

}
