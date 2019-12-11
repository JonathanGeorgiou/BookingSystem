package com.bae.bookingsystem.service;

import com.bae.bookingsystem.persistance.domain.Customer;
import com.bae.bookingsystem.persistance.repo.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * BookingService
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

	public Customer createCustomer(com.bae.bookingsystem.persistance.domain.Customer user) {
		return null;
	}

    //add an autowired repo object
    //put all the methods that interact with the database
    // in here

    
}