package com.cgbank.customers.customer;

import java.util.List;


public interface CustomerService {
	Customer save(Customer customer) ;



	Customer getCustomerByID(Long id);

}
