package com.cgbank.accounts.account.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.InheritanceType;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Entity() 
@Table(name="account_type")
@Inheritance(
	    strategy = InheritanceType.JOINED
	)
@DiscriminatorColumn(name="ACC_TYPE")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "ACC_TYPE")
@JsonSubTypes({
  @JsonSubTypes.Type(value = CheckingAccount.class, name = "CHECKING"),
  @JsonSubTypes.Type(value = SavingsAccount.class, name = "SAVINGS")
})

public abstract class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id 
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	private int id;
	
    private String name;
    
    private Long balance;
    
    private Long apr;
    
    private Long minBalance;
    
    @NotNull
    private Long userid;
    
    @Column(name = "is_authorized", columnDefinition="DEFAULT boolean  0")
    private Boolean is_authorized ;
    
    @Column(name = "is_auth", columnDefinition="DEFAULT boolean  0")
    private Boolean is_auth ;
   
   
    public Account() {
    	
    }

	public Account(int id, String name, Long balance, Long apr, Long minBalance, Long userid, Boolean isAuthorized ,Boolean is_auth) {
		super();
		this.minBalance = minBalance;
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.apr = apr;
		this.userid = userid;
		this.is_authorized = isAuthorized;
		this.is_auth =is_auth;
	}

	
	public Long getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(Long minBalance) {
		this.minBalance = minBalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getApr() {
		return apr;
	}

	public void setApr(Long apr) {
		this.apr = apr;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Boolean getIsAuthorized() {
		return is_authorized;
	}

	public void setIsAuthorized(Boolean isAuthorized) {
		this.is_authorized = isAuthorized;
	}
	

}
