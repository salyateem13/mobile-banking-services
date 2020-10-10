package com.cgbank.customers.customer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name="customer")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3009157732242241606L;

	@Id
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	private Long id;
	
	private Long userid;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	private String occupation;

	private String incomeSource;
	
	private String bFirstName;
	
	private String bLastName;
	
	private String bStreetAddress;

	private String bCity;
	
	private String bState;
	
	private String bEmail;

	
	@Lob
    private byte[] identification;
	
	@Lob
    private byte[] proofOfAddress;
	
	public Customer() {
		
	}

	public Customer(Long id, Long userid, String firstName, String lastName, String streetAddress, String city, String state,
			String occupation, String incomeSource, String bFirstName, String bLastName, String bStreetAddress,
			String bCity, String bState, String bEmail, byte[] identification, byte[] proofOfAddress) {
		
		this.id = id;
		this.setUserid(userid);
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.occupation = occupation;
		this.incomeSource = incomeSource;
		this.bFirstName = bFirstName;
		this.bLastName = bLastName;
		this.bStreetAddress = bStreetAddress;
		this.bCity = bCity;
		this.bState = bState;
		this.identification = identification;
		this.proofOfAddress = proofOfAddress;
		this.setbEmail(bEmail);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getIncomeSource() {
		return incomeSource;
	}

	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}

	public String getbFirstName() {
		return bFirstName;
	}

	public void setbFirstName(String bFirstName) {
		this.bFirstName = bFirstName;
	}

	public String getbLastName() {
		return bLastName;
	}

	public void setbLastName(String bLastName) {
		this.bLastName = bLastName;
	}

	public String getbStreetAddress() {
		return bStreetAddress;
	}

	public void setbStreetAddress(String bStreetAddress) {
		this.bStreetAddress = bStreetAddress;
	}

	public String getbCity() {
		return bCity;
	}

	public void setbCity(String bCity) {
		this.bCity = bCity;
	}

	public String getbState() {
		return bState;
	}

	public void setbState(String bState) {
		this.bState = bState;
	}

	public byte[] getIdentification() {
		return identification;
	}

	public void setIdentification(byte[] identification) {
		this.identification = identification;
	}

	public byte[] getProofOfAddress() {
		return proofOfAddress;
	}

	public void setProofOfAddress(byte[] proofOfAddress) {
		this.proofOfAddress = proofOfAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}
	
}
