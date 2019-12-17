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

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

}