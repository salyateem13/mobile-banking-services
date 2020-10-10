package com.cgbank.accounts.account.checking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgbank.accounts.account.models.CheckingAccount;
@Repository
public interface CheckingRepository extends CrudRepository<CheckingAccount, Long> {

}