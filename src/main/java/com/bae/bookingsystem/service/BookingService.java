package com.bae.bookingsystem.service;

import com.bae.bookingsystem.persistance.domain.Booking;
import com.bae.bookingsystem.persistance.repo.BookingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//timeOfBooking 

/**
 * BookingService
 */
@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

}