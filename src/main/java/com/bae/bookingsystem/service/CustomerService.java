package com.bae.bookingsystem.service;

import java.util.Date;
import java.util.List;

import com.bae.bookingsystem.persistance.domain.Booking;
import com.bae.bookingsystem.persistance.domain.Customer;
import com.bae.bookingsystem.persistance.repo.BookingRepo;
import com.bae.bookingsystem.persistance.repo.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BookingService
 */
@Service
public class CustomerService {

    private CustomerRepo customerRepo;
    private BookingRepo bookingRepo;
    private Customer customer;
    List<Booking> storedBookings = bookingRepo.findAll();
    List<Date> storedTimes;
    private Booking booking;

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

    public List<Customer> readCustomers() {
        return this.customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer, long id) {
        Customer custToUpdate = findCustomer(id);
        custToUpdate.setFirstName(customer.getFirstName());
        custToUpdate.setLastName(customer.getLastName());
        custToUpdate.setEmail(customer.getEmail());
        custToUpdate.setPhoneNumber(customer.getPhoneNumber());
        custToUpdate.setBookings(customer.getBookings());
        return this.customerRepo.save(custToUpdate);
    }

    public String deleteCustomer(long id) {
        customer = this.customerRepo.findById(id).get();
        this.customerRepo.deleteById(id);
        return customer.getFirstName() + " " + customer.getLastName() + " has been deleted from the database.";
    }

}