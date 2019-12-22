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

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer findCustomer(long id) {
        return this.customerRepo.findById(id).get();
    }

}