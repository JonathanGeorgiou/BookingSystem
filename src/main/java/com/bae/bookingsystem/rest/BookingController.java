package com.bae.bookingsystem.rest;

import javax.validation.Valid;

import com.bae.bookingsystem.persistance.domain.Booking;

import com.bae.bookingsystem.service.BookingService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * BookingController
 */
@RestController
@RequestMapping
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/createBooking")
    public Booking postBooking(@RequestBody @Valid Booking booking) {
        return this.bookingService.createBooking(booking);
    }
}
