package com.bae.bookingsystem.rest;

import java.util.List;

import javax.validation.Valid;

import com.bae.bookingsystem.persistance.domain.Customer;
import com.bae.bookingsystem.service.CustomerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * BookingController
 */
@RestController
@RequestMapping
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // "2012-04-23T18:25:43.511Z" datetime format needed in postman
    @PostMapping("/createCustomer")
    public Customer postCustomer(@RequestBody @Valid Customer customer) {
        return this.customerService.createCustomer(customer);
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> getAllCustomers() {
        return this.customerService.readCustomers();
    }

    @GetMapping("/findCustomer/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return this.customerService.findCustomer(id);
    }

    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        return this.customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
    }

}