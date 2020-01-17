package com.bae.bookingsystem.service;

import java.util.List;

import com.bae.bookingsystem.exceptions.CustomerNotFoundException;
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

    public Customer findCustomer(Long id) {
        return this.customerRepo.findById(id).get();
    }

    public List<Customer> readCustomers() {
        return this.customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer, Long id) {
        Customer custToUpdate = findCustomer(id);
        custToUpdate.setFirstName(customer.getFirstName());
        custToUpdate.setLastName(customer.getLastName());
        custToUpdate.setEmail(customer.getEmail());
        custToUpdate.setPhoneNumber(customer.getPhoneNumber());
        custToUpdate.setBookings(customer.getBookings());
        return this.customerRepo.save(custToUpdate);
    }

    public boolean deleteCustomer(Long id) {
        if (!this.customerRepo.existsById(id)) {
            throw new CustomerNotFoundException();
        }

        this.customerRepo.deleteById(id);
        return this.customerRepo.existsById(id);

    }

}