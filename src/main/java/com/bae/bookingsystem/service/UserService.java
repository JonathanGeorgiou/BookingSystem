package com.bae.bookingsystem.service;

import com.bae.bookingsystem.persistance.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BookingService
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //add an autowired repo object
    //put all the methods that interact with the database
    // in here

    
}