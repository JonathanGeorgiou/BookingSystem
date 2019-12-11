package com.bae.bookingsystem.rest;

import com.bae.bookingsystem.persistance.domain.Customer;
import com.bae.bookingsystem.service.CustomerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.fasterxml.jackson.annotation.JsonAnyGetter;

import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;





/**
 * BookingController
 */
@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createClient")
    public Customer createUser(@RequestBody Customer customer) {
		return this.customerService.createCustomer(customer);
	}

    // need these in this class to call upon our service methods and 
    // send them to a http address
    // @GetMapping
    // @PostMapping

    // @PutMapping

    // @DeleteMapping
    

    
}